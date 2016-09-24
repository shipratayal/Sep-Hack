databaseChangeLog = {

	changeSet(author: "nakul (generated)", id: "1474696201286-1") {
		createTable(tableName: "repository") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "repositoryPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "access_level", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "text") {
				constraints(nullable: "false")
			}

			column(name: "is_deleted", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "object_status", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "owner_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "unique_id", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "nakul (generated)", id: "1474696201286-2") {
		createTable(tableName: "repository_teams") {
			column(name: "repository_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "team_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "nakul (generated)", id: "1474696201286-3") {
		createTable(tableName: "team") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "teamPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "is_deleted", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(20)") {
				constraints(nullable: "false")
			}

			column(name: "object_status", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "unique_id", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "nakul (generated)", id: "1474696201286-4") {
		createTable(tableName: "team_user") {
			column(name: "team_members_id", type: "bigint")

			column(name: "user_id", type: "bigint")
		}
	}

	changeSet(author: "nakul (generated)", id: "1474696201286-5") {
		addPrimaryKey(columnNames: "repository_id, team_id", tableName: "repository_teams")
	}

	changeSet(author: "nakul (generated)", id: "1474696201286-11") {
		createIndex(indexName: "FK_3f4oefeff08pojy6d4l9g8u0w", tableName: "repository") {
			column(name: "owner_id")
		}
	}

	changeSet(author: "nakul (generated)", id: "1474696201286-12") {
		createIndex(indexName: "FK_hlynhccq3d68bfhjhe8ib64jx", tableName: "repository_teams") {
			column(name: "repository_id")
		}
	}

	changeSet(author: "nakul (generated)", id: "1474696201286-13") {
		createIndex(indexName: "FK_n3iouff4fijanf9pbqt0699ss", tableName: "repository_teams") {
			column(name: "team_id")
		}
	}

	changeSet(author: "nakul (generated)", id: "1474696201286-14") {
		createIndex(indexName: "FK_f9m3vjnh6u5yg0l0epna2kla8", tableName: "team_user") {
			column(name: "user_id")
		}
	}

	changeSet(author: "nakul (generated)", id: "1474696201286-15") {
		createIndex(indexName: "FK_jfn44gpqsb8d76rrmty0sh83d", tableName: "team_user") {
			column(name: "team_members_id")
		}
	}

	changeSet(author: "nakul (generated)", id: "1474696201286-6") {
		addForeignKeyConstraint(baseColumnNames: "owner_id", baseTableName: "repository", constraintName: "FK_3f4oefeff08pojy6d4l9g8u0w", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "nakul (generated)", id: "1474696201286-7") {
		addForeignKeyConstraint(baseColumnNames: "repository_id", baseTableName: "repository_teams", constraintName: "FK_hlynhccq3d68bfhjhe8ib64jx", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "repository", referencesUniqueColumn: "false")
	}

	changeSet(author: "nakul (generated)", id: "1474696201286-8") {
		addForeignKeyConstraint(baseColumnNames: "team_id", baseTableName: "repository_teams", constraintName: "FK_n3iouff4fijanf9pbqt0699ss", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "team", referencesUniqueColumn: "false")
	}

	changeSet(author: "nakul (generated)", id: "1474696201286-9") {
		addForeignKeyConstraint(baseColumnNames: "team_members_id", baseTableName: "team_user", constraintName: "FK_jfn44gpqsb8d76rrmty0sh83d", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "team", referencesUniqueColumn: "false")
	}

	changeSet(author: "nakul (generated)", id: "1474696201286-10") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "team_user", constraintName: "FK_f9m3vjnh6u5yg0l0epna2kla8", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}
}
