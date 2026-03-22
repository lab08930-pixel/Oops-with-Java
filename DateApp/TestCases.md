# Date Engine Robustness & Integration Test Plan

This document outlines the **6 Core Stress Tests** and **3 Integration Scenarios** required to verify the accuracy of the `DateCheck` and `DateOperation` classes.

---

## 1. Core Logic "Stress Tests"
These tests verify that the fundamental mathematical rules of the Gregorian Calendar are handled correctly by the `daysToDate` and `totalDays` methods.

### 1.1 The Leap Year "Triple Point" (Year 2000)
* **The Logic:** Most years divisible by 100 are NOT leap years, but those divisible by 400 **are**.
* **Input Date:** `28 / 02 / 2000`
* **Action:** Add `1` day.
* **Expected Result:** `29 / 02 / 2000`
* **Failure Sign:** If it says `01/03/2000`, the `% 400` logic is broken.

### 1.2 The Century "Skip" (Year 2100)
* **The Logic:** 2100 is divisible by 4, but it is **not** a leap year because it is divisible by 100 (and not 400).
* **Input Date:** `28 / 02 / 2100`
* **Action:** Add `1` day.
* **Expected Result:** `01 / 03 / 2100`
* **Failure Sign:** If it says `29/02/2100`, the `% 100` skip rule was forgotten.

### 1.3 The New Year's Eve Rollover
* **The Logic:** Tests if both the month and the year increment correctly at the same time.
* **Input Date:** `31 / 12 / 2023`
* **Action:** Add `1` day.
* **Expected Result:** `01 / 01 / 2024`
* **Comparison:** Compare `31/12/2023` and `01/01/2024`. The difference should be exactly **1 day**.

### 1.4 The 400-Year Cycle Jump
* **The Logic:** Tests if the `cycles400` math in `daysToDate` is perfect over exactly one Gregorian cycle.
* **Input Date:** `01 / 01 / 2000`
* **Action:** Add `146,097` days (Exactly 400 years).
* **Expected Result:** `01 / 01 / 2400`

### 1.5 The "Big Gap" Comparison
* **The Logic:** Tests the `long` precision and absolute difference between the start of history and the modern era.
* **Date 1:** `01 / 01 / 0001` (Day 1 of history)
* **Date 2:** `01 / 01 / 2001`
* **Expected Result:** Difference of **730,485 days**.
* **The Math:** $(365 \times 2000) + 485 \text{ leap days} = 730,485$.

### 1.6 The February "Normal Year" Check
* **The Logic:** Ensures February doesn't stay 29 days forever and behaves correctly in non-leap years.
* **Input Date:** `28 / 02 / 2023` (2023 is NOT a leap year).
* **Action:** Add `1` day.
* **Expected Result:** `01 / 03 / 2023`

---

## 2. Integration Testing
These tests verify that `addDays` (moving forward) and `compareDates` (calculating distance) are perfectly synchronized.

### Test 1: The "Add and Subtract" Loop
* **Goal:** Verify that moving forward by a specific amount results in that exact mathematical difference.
1.  Set Date 1: `01 / 01 / 2024`
2.  Action: Add **366 days**. (Should land on `01 / 01 / 2025`).
3.  Set Date 2: `01 / 01 / 2025`.
4.  **Expected Comparison:** Difference: **366 days**.

### Test 2: The "Century Cross" Comparison
* **Goal:** Verify that the code handles the non-leap century (2100) consistently across both methods.
1.  Set Date 1: `28 / 02 / 2099`
2.  Action: Add **366 days**. (Should land on `01 / 03 / 2100`).
3.  Set Date 2: `01 / 03 / 2100`.
4.  **Expected Comparison:** Difference: **366 days**.

### Test 3: The "Large Jump" Stability
* **Goal:** Ensure `long` precision works over massive gaps between 100-year blocks.
1.  Set Date 1: `01 / 01 / 2000`
2.  Action: Add **36,525 days**. (Exactly 100 years including 25 leaps).
3.  Set Date 2: `01 / 01 / 2100`.
4.  **Expected Comparison:** Difference: **36,525 days**.

---

## 3. Results Analysis
* **If you get a Date:** Your `daysToDate` is working.
* **If you get a Difference:** Your `totalDays` and `compareDates` are working.
* **If the Difference is 1 but the Date is wrong:** Your leap year logic is inconsistent (one method thinks it's a leap year, the other doesn't).
* **If the Date display looks weird:** Re-check the `setDate` validation logic.