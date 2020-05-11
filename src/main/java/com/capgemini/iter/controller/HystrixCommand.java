package com.capgemini.iter.controller;

public @interface HystrixCommand {

	String fallbackMethod();

}
