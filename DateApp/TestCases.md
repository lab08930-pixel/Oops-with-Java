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


  To test your new menu-driven system, we need to verify that **Adding Days**, **Adding Months**, and **Comparing Dates** all work together flawlessly. 

Since your current date is **March 23, 2026**, let’s use that as our starting point! 

Follow this specific sequence of inputs to test every "logic gate" in your code:

---

### Phase 1: The "Month Pinning" Test
This tests if your `addMonths` correctly handles February's shorter length.

1.  **Initial Setup:** Enter **31 / 01 / 2026** (January 31st).
2.  **Select Option 2 (Add Months):** Enter **1**.
    * **Expected Result:** `28 / 02 / 2026`. 
    * *Logic Check: It should "pin" the 31st to the 28th because Feb 31 doesn't exist.*
3.  **Select Option 2 again:** Enter **1**.
    * **Expected Result:** `28 / 03 / 2026`.
    * *Logic Check: It stays on the 28th because that is the new current day.*

---

### Phase 2: The "Big Jump" Test
This verifies your $O(1)$ math for large month additions.

1.  **Select Option 4 (Reset):** Enter **22 / 03 / 2026**.
2.  **Select Option 2 (Add Months):** Enter **573**.
    * **Expected Result:** `22 / 12 / 2073`.
    * *Logic Check: This confirms your `totalMonths / 12` logic spans decades correctly.*

---

### Phase 3: The "Year Rollover" Test
This ensures the year increments when days cross the December 31st boundary.

1.  **Select Option 4 (Reset):** Enter **30 / 12 / 2023**.
2.  **Select Option 1 (Add Days):** Enter **2**.
    * **Expected Result:** `01 / 01 / 2024`.
    * *Logic Check: Tests if the month and year both increment at the same time.*

---

### Phase 4: The "Integration" Test
This checks if `addDays` and `compareDates` are synchronized.

1.  **Select Option 4 (Reset):** Enter **01 / 01 / 2024**.
2.  **Select Option 1 (Add Days):** Enter **366**.
    * **Expected Result:** `01 / 01 / 2025` (Since 2024 is a leap year).
3.  **Select Option 3 (Compare):** Enter **01 / 01 / 2024**.
    * **Expected Result:** `Difference: 366 days`.
    * *Logic Check: If the difference is exactly 366, your leap year math is identical in both classes.*

---

### Phase 5: The "Century Skip" Test
The ultimate test for your `% 100` rule.

1.  **Select Option 4 (Reset):** Enter **28 / 02 / 2100**.
2.  **Select Option 1 (Add Days):** Enter **1**.
    * **Expected Result:** `01 / 03 / 2100`.
    * *Logic Check: If it says `29/02/2100`, your century skip logic is failing.*

---

### Troubleshooting Tips:
* **Infinite Loop?** Make sure you have `break;` at the end of every `case` in your switch statement.
* **Wrong Year?** Check if you are using `oldYear` or `newYear` in your `addMonths` return.
* **Validation Error?** If your `setDate` rejects a valid date (like a leap day), double-check your `isLeap` method's logic.

**How did Phase 1 (The January to February pin) turn out on your console?**
