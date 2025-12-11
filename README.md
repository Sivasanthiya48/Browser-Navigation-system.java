# Browser-Navigation-system.java
# Browser Navigation System (Using Stacks in Java)

This project simulates how a web browser handles **Back**, **Forward**, and **Visit** navigation using **two stacks**.  
It is a simple console-based Java application suitable for academic projects, DSA practice, and GitHub portfolio.

--

## Project Description

A typical web browser allows the user to:

- Visit a URL
- Navigate Back
- Navigate Forward
- View history stacks

This project demonstrates how browsers maintain history internally using two stacks:

- Back Stack
- Forward Stack

Each action updates the stacks just like a real browser.

---

##  Concept Used: Two-Stack Navigation

###  When Visiting a New URL
- Push current page → Back Stack
- Clear the Forward Stack
- New URL becomes current page

###  When Clicking Back
- Push current page → Forward Stack
- Pop from Back Stack → set as current page

###  When Clicking Forward
- Push current page → **Back Stack**
- Pop from Forward Stack → set as current page

---

## Algorithm

1. Start the program  
2. Initialize:
   - `backStack`
   - `forwardStack`
   - `current` page  
3. Display menu repeatedly  
4. If Visit:
   - Push current into backStack  
   - Set new URL as current  
   - Clear forwardStack  
5. If Back:
   - Push current to forwardStack  
   - Pop from backStack → set as current  
6. If Forward:
   - Push current to backStack  
   - Pop from forwardStack → set as current  
7. If Show Page, print current  
8. Repeat menu until user selects Exit  
9. Stop the program  

---

## Sample Output
Visited: google.com

=== Browser Status ===
Current Page : google.com
Back Stack   : []
Forward Stack: []
=======================

Visited: youtube.com

=== Browser Status ===
Current Page : youtube.com
Back Stack   : [google.com]
Forward Stack: []
=======================

Moved Back → google.com

=== Browser Status ===
Current Page : google.com
Back Stack   : []
Forward Stack: [youtube.com]
======================
