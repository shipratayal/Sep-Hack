package com.nexthoughts.stuff

import com.nexthoughts.issuetracker.Repository
import com.nexthoughts.issuetracker.enums.ObjectStatus

class Label {
    String title
    String color
    ObjectStatus objectStatus = ObjectStatus.CURRENT
    Boolean isDeleted = Boolean.FALSE
    Date dateCreated
    Date lastUpdated
    static belongsTo = [repository: Repository]

    static constraints = {
        title nullable: false, blank: false
        color nullable: true, false: true
    }

    public static List<Label> getLabelsForRepository(def repositoryId){
        Label.findAllByRepository(Repository.get(repositoryId as Long))
    }
}
