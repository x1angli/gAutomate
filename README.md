# gAutomate

This repo provides a collection of Groovy scripts. It solves a bunch of day-to-day problems that might otherwise become boring to human beings by leveraging computer's automation power.

# Installation

1. Have Java SDK and Groovy installed. Also, an IDE is highly recommended.
2. Fork the code from this repo.
3. Choose a Java class and run it. Most Java classes here are standalone, meaning they do not depend on 3rd-party artifacts.

# Introduction

## brutalcoupon.groovy

This Groovy script is used to automatically iterate through all coupon codes within specified range. 

One day, I got a coupon code for a merchant. But the paper on which the code is printed was damaged, thus there was one digit illegible. To solve the problem, I wrote this Groovy script. It works like a brute-force password cracker by trying all possible combinations within the range. Since most coupon code input box are segmented, it mimics the keyboard actions by automatically put in the code for each trial. Currently ,the code pauses for a brief period so that user can manually determine whether the code works or not.
