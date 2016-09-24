databaseChangeLog = {

    changeSet(author: "vijay (generated)", id: "1474691164850-1") {
        createTable(tableName: "role") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolePK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "authority", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "vijay (generated)", id: "1474691164850-2") {
        createTable(tableName: "user") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "userPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "account_expired", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "account_locked", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "enabled", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "password", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "password_expired", type: "bit") {
                constraints(nullable: "false")
            }

            column(name: "username", type: "varchar(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "vijay (generated)", id: "1474691164850-3") {
        createTable(tableName: "user_role") {
            column(name: "user_id", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "role_id", type: "bigint") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "vijay (generated)", id: "1474691164850-4") {
        addPrimaryKey(columnNames: "user_id, role_id", constraintName: "user_rolePK", tableName: "user_role")
    }

    changeSet(author: "vijay (generated)", id: "1474691164850-7") {
        createIndex(indexName: "authority_uniq_1474691164763", tableName: "role", unique: "true") {
            column(name: "authority")
        }
    }

    changeSet(author: "vijay (generated)", id: "1474691164850-8") {
        createIndex(indexName: "username_uniq_1474691164772", tableName: "user", unique: "true") {
            column(name: "username")
        }
    }

    changeSet(author: "vijay (generated)", id: "1474691164850-9") {
        createIndex(indexName: "FK_apcc8lxk2xnug8377fatvbn04", tableName: "user_role") {
            column(name: "user_id")
        }
    }

    changeSet(author: "vijay (generated)", id: "1474691164850-10") {
        createIndex(indexName: "FK_it77eq964jhfqtu54081ebtio", tableName: "user_role") {
            column(name: "role_id")
        }
    }

    changeSet(author: "vijay (generated)", id: "1474691164850-5") {
        addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK_it77eq964jhfqtu54081ebtio", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
    }

    changeSet(author: "vijay (generated)", id: "1474691164850-6") {
        addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK_apcc8lxk2xnug8377fatvbn04", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
    }

    

	include file: 'repositoryAndTeam.groovy'

	include file: 'addFirstNameAndLastNameToUser.groovy'

	include file: 'addProfileToTeam.groovy'

	include file: 'stuffAndNotif.groovy'
}
