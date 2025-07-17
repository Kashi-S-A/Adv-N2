package com.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(value = "prototype")
public class Employee {

}
