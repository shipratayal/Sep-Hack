package com

import grails.plugin.springsecurity.annotation.Secured


@Secured(["permitAll"])
class TestController {


    def mailService

    def sendSimpleMail() {
        MailCO mailCO = new MailCO()
        mailCO.from = "testing@sparkpostbox.com"
        mailCO.to = ["vijay@nexthoughts.com"]
        mailCO.subject = "This mail is for testing"
        mailService.sendSimpleMailWithoutAttachment(mailCO)
        render "Successfull"
    }

    def tinyMce = {
        println("======= Sis this executed=========")
        render view: 'tinyMce'
    }

    def saveText = {
        String text = params.editor1
        text = text.replaceAll("\\<.*?\\>", "")
        MailCO mailCO = new MailCO()
        mailCO.from = "testing@sparkpostbox.com"
        mailCO.to = ["vijay@nexthoughts.com","deshraj@nexthoughts.com"]
        mailCO.subject = "Tiny Mce Text Test"
        mailCO.viewFileName = "/test/tinyMceMailTemplate"
        mailCO.modelMap = [text: text]
        Thread.start {
            mailService.sendSimpleMailWithoutAttachment(mailCO)
        }
        render "Successfull"
    }
}
