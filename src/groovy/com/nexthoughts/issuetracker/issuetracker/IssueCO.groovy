package com.nexthoughts.issuetracker.issuetracker

import grails.validation.Validateable

@Validateable
class IssueCO {

    String title
    String editor1
    List<String> labels
    String milestone
    List<String> authors

}
