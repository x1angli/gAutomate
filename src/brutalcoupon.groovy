#!/usr/bin/env groovy

package li.x1ang.gautomation;

import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 * Created by x1ang.li on 2016/2/11.
 *
 * This Groovy script is used to automatically iterate through all coupon codes within specified range.
 * One day, I got a coupon code for a merchant. But the paper on which the code is printed was damaged,
 * thus there was one digit illegible. To solve the problem, I wrote this Groovy script. It works like
 * a brute-force password cracker by trying all possible combinations within the range. Since most
 * coupon code input box are segmented, it mimics the keyboard actions by automatically put in the
 * code for each trial. Currently ,the code pauses for a brief period so that user can manually
 * determine whether the code works or not.
 *
 * DO NOT ABUSE OR MISUSE this tool.
 */

// --- Start of config --- //
def missing = ''
def range = '0123456789abcdef' // hexadecimal
def template = "f384${-> missing}764663c81d1" // Put in all legible parts of the coupon code here
// Use closure to enforce lazy evaluation

def breakTime = 4   // # of seconds between each trial

// --- End of config --- //

def robot = new Robot()

println("I am running");
println("Please activate the window, focus on the coupon code inputbox, and be prepared")
robot.delay(0 * 1000); // Delay for three seconds

def typechar = {
    robot.delay(30);    //Prevent UI stuck and crash
    robot.keyPress(it)
    robot.keyRelease(it)
}

def typecode = {
    missing = it

    template.getBytes().each {
        typechar(it)
    }
    typechar(KeyEvent.VK_ENTER)

    println("Just typed: " + template);

    robot.delay(breakTime * 1000);
    // You are supposed to take advantage of this period of time to check whether it's confirmed or not
}

range.each {
    typecode((String)it)
}

println("I am finished.");


