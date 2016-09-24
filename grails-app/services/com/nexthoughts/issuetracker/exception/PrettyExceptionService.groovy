package com.nexthoughts.issuetracker.exception

import grails.transaction.NotTransactional
import grails.transaction.Transactional

@Transactional
class PrettyExceptionService {

    @NotTransactional
    void flush(String message, Exception e) {
        log.info("===============================START=================================")
        log.info(message)
        log.info("Exception Catched at =============== " + new Date())
        log.info("==================================================================")
        e.printStackTrace()
        log.info("==================================================================")
        log.info(message)
        log.info("===============================END===================================")
    }
}
