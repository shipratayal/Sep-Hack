databaseChangeLog = {

	changeSet(author: "vijay (generated)", id: "1474701699808-1") {
		createTable(tableName: "attachments") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "attachmentsPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "attachment_content_type", type: "varchar(255)")

			column(name: "attachment_name", type: "varchar(255)")

			column(name: "attachment_path_name", type: "varchar(255)")

			column(name: "comment_id", type: "bigint")

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "is_deleted", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "issue_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "object_status", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-2") {
		createTable(tableName: "comment") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "commentPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "commented_by_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "longtext") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-3") {
		createTable(tableName: "comment_user") {
			column(name: "comment_notifies_id", type: "bigint")

			column(name: "user_id", type: "bigint")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-4") {
		createTable(tableName: "issue") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "issuePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "created_by_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "text")

			column(name: "is_deleted", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "issue_status", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "mile_stone_id", type: "bigint")

			column(name: "object_status", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "project_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "title", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "unique_id", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-5") {
		createTable(tableName: "issue_comment") {
			column(name: "issue_comments_id", type: "bigint")

			column(name: "comment_id", type: "bigint")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-6") {
		createTable(tableName: "issue_label") {
			column(name: "issue_labels_id", type: "bigint")

			column(name: "label_id", type: "bigint")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-7") {
		createTable(tableName: "issue_user") {
			column(name: "issue_assignees_id", type: "bigint")

			column(name: "user_id", type: "bigint")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-8") {
		createTable(tableName: "label") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "labelPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "color", type: "varchar(255)")

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "is_deleted", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "object_status", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "repository_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "title", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-9") {
		createTable(tableName: "mile_stone") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "mile_stonePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(255)")

			column(name: "due_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "is_deleted", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "object_status", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "repository_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "title", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-10") {
		createTable(tableName: "notification") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "notificationPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "created_by_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "status", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "type", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "unique_id", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-11") {
		createTable(tableName: "notification_user") {
			column(name: "notification_notify_to_id", type: "bigint")

			column(name: "user_id", type: "bigint")

			column(name: "notification_read_by_id", type: "bigint")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-12") {
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

	changeSet(author: "vijay (generated)", id: "1474701699808-13") {
		createTable(tableName: "repository_teams") {
			column(name: "team_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "repository_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-14") {
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

	changeSet(author: "vijay (generated)", id: "1474701699808-15") {
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

			column(name: "team_profile", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "unique_id", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-16") {
		createTable(tableName: "team_user") {
			column(name: "team_members_id", type: "bigint")

			column(name: "user_id", type: "bigint")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-17") {
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

			column(name: "first_name", type: "varchar(12)") {
				constraints(nullable: "false")
			}

			column(name: "last_name", type: "varchar(12)") {
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

	changeSet(author: "vijay (generated)", id: "1474701699808-18") {
		createTable(tableName: "user_role") {
			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "role_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-19") {
		addPrimaryKey(columnNames: "repository_id, team_id", tableName: "repository_teams")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-20") {
		addPrimaryKey(columnNames: "user_id, role_id", constraintName: "user_rolePK", tableName: "user_role")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-48") {
		createIndex(indexName: "FK_fkma8athhaxpg7814w6s80yh7", tableName: "attachments") {
			column(name: "issue_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-49") {
		createIndex(indexName: "FK_hlgd3nqmn1mopr4ait0254eas", tableName: "attachments") {
			column(name: "comment_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-50") {
		createIndex(indexName: "FK_kyjvp1i6gbv9vtp2tpwy8qxc1", tableName: "comment") {
			column(name: "commented_by_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-51") {
		createIndex(indexName: "FK_9to8qh3or7i1hr3w2fdag0kd3", tableName: "comment_user") {
			column(name: "comment_notifies_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-52") {
		createIndex(indexName: "FK_obutvg4o609wp066ipmoky7ar", tableName: "comment_user") {
			column(name: "user_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-53") {
		createIndex(indexName: "FK_73kl4d88gc5ct5iq6blo13ow4", tableName: "issue") {
			column(name: "project_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-54") {
		createIndex(indexName: "FK_ixka0fo05tgbfn5edwgcby3fs", tableName: "issue") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-55") {
		createIndex(indexName: "FK_p7ryfojxujwurm7tblcks6035", tableName: "issue") {
			column(name: "mile_stone_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-56") {
		createIndex(indexName: "FK_4r9jve2lvb0cowupc1fxey59q", tableName: "issue_comment") {
			column(name: "comment_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-57") {
		createIndex(indexName: "FK_a9ju9l6tw1psjodvxqo1ksnwi", tableName: "issue_comment") {
			column(name: "issue_comments_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-58") {
		createIndex(indexName: "FK_bq8ko2fisw0ntm2x1837inou4", tableName: "issue_label") {
			column(name: "issue_labels_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-59") {
		createIndex(indexName: "FK_g25qu9af5rxkj15kyjxlxn6gr", tableName: "issue_label") {
			column(name: "label_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-60") {
		createIndex(indexName: "FK_5uj41kx9aw7cnord2l42a6bu5", tableName: "issue_user") {
			column(name: "user_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-61") {
		createIndex(indexName: "FK_6kx9j11hgl98alpy241a8cdi8", tableName: "issue_user") {
			column(name: "issue_assignees_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-62") {
		createIndex(indexName: "FK_apdwyj7kq5egsd8k8h4li1n5o", tableName: "label") {
			column(name: "repository_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-63") {
		createIndex(indexName: "FK_sdso6jye4bg8wtscpoxxn7kf6", tableName: "mile_stone") {
			column(name: "repository_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-64") {
		createIndex(indexName: "FK_6imf4pimjkp0ifsm9elywa7h", tableName: "notification") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-65") {
		createIndex(indexName: "FK_54ptemgd0wicq8djc1dsycy5", tableName: "notification_user") {
			column(name: "notification_notify_to_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-66") {
		createIndex(indexName: "FK_7iq8wfwh6nrr9x0x8555uk4ux", tableName: "notification_user") {
			column(name: "user_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-67") {
		createIndex(indexName: "FK_i0u1b2bm0gfnca9cbyt0gmcip", tableName: "notification_user") {
			column(name: "notification_read_by_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-68") {
		createIndex(indexName: "FK_3f4oefeff08pojy6d4l9g8u0w", tableName: "repository") {
			column(name: "owner_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-69") {
		createIndex(indexName: "FK_hlynhccq3d68bfhjhe8ib64jx", tableName: "repository_teams") {
			column(name: "repository_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-70") {
		createIndex(indexName: "FK_n3iouff4fijanf9pbqt0699ss", tableName: "repository_teams") {
			column(name: "team_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-71") {
		createIndex(indexName: "authority_uniq_1474701699725", tableName: "role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-72") {
		createIndex(indexName: "FK_f9m3vjnh6u5yg0l0epna2kla8", tableName: "team_user") {
			column(name: "user_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-73") {
		createIndex(indexName: "FK_jfn44gpqsb8d76rrmty0sh83d", tableName: "team_user") {
			column(name: "team_members_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-74") {
		createIndex(indexName: "username_uniq_1474701699735", tableName: "user", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-75") {
		createIndex(indexName: "FK_apcc8lxk2xnug8377fatvbn04", tableName: "user_role") {
			column(name: "user_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-76") {
		createIndex(indexName: "FK_it77eq964jhfqtu54081ebtio", tableName: "user_role") {
			column(name: "role_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-21") {
		addForeignKeyConstraint(baseColumnNames: "comment_id", baseTableName: "attachments", constraintName: "FK_hlgd3nqmn1mopr4ait0254eas", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "comment", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-22") {
		addForeignKeyConstraint(baseColumnNames: "issue_id", baseTableName: "attachments", constraintName: "FK_fkma8athhaxpg7814w6s80yh7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "issue", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-23") {
		addForeignKeyConstraint(baseColumnNames: "commented_by_id", baseTableName: "comment", constraintName: "FK_kyjvp1i6gbv9vtp2tpwy8qxc1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-24") {
		addForeignKeyConstraint(baseColumnNames: "comment_notifies_id", baseTableName: "comment_user", constraintName: "FK_9to8qh3or7i1hr3w2fdag0kd3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "comment", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-25") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "comment_user", constraintName: "FK_obutvg4o609wp066ipmoky7ar", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-26") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "issue", constraintName: "FK_ixka0fo05tgbfn5edwgcby3fs", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-27") {
		addForeignKeyConstraint(baseColumnNames: "mile_stone_id", baseTableName: "issue", constraintName: "FK_p7ryfojxujwurm7tblcks6035", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "mile_stone", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-28") {
		addForeignKeyConstraint(baseColumnNames: "project_id", baseTableName: "issue", constraintName: "FK_73kl4d88gc5ct5iq6blo13ow4", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "repository", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-29") {
		addForeignKeyConstraint(baseColumnNames: "comment_id", baseTableName: "issue_comment", constraintName: "FK_4r9jve2lvb0cowupc1fxey59q", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "comment", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-30") {
		addForeignKeyConstraint(baseColumnNames: "issue_comments_id", baseTableName: "issue_comment", constraintName: "FK_a9ju9l6tw1psjodvxqo1ksnwi", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "issue", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-31") {
		addForeignKeyConstraint(baseColumnNames: "issue_labels_id", baseTableName: "issue_label", constraintName: "FK_bq8ko2fisw0ntm2x1837inou4", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "issue", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-32") {
		addForeignKeyConstraint(baseColumnNames: "label_id", baseTableName: "issue_label", constraintName: "FK_g25qu9af5rxkj15kyjxlxn6gr", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "label", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-33") {
		addForeignKeyConstraint(baseColumnNames: "issue_assignees_id", baseTableName: "issue_user", constraintName: "FK_6kx9j11hgl98alpy241a8cdi8", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "issue", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-34") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "issue_user", constraintName: "FK_5uj41kx9aw7cnord2l42a6bu5", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-35") {
		addForeignKeyConstraint(baseColumnNames: "repository_id", baseTableName: "label", constraintName: "FK_apdwyj7kq5egsd8k8h4li1n5o", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "repository", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-36") {
		addForeignKeyConstraint(baseColumnNames: "repository_id", baseTableName: "mile_stone", constraintName: "FK_sdso6jye4bg8wtscpoxxn7kf6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "repository", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-37") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "notification", constraintName: "FK_6imf4pimjkp0ifsm9elywa7h", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-38") {
		addForeignKeyConstraint(baseColumnNames: "notification_notify_to_id", baseTableName: "notification_user", constraintName: "FK_54ptemgd0wicq8djc1dsycy5", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "notification", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-39") {
		addForeignKeyConstraint(baseColumnNames: "notification_read_by_id", baseTableName: "notification_user", constraintName: "FK_i0u1b2bm0gfnca9cbyt0gmcip", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "notification", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-40") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "notification_user", constraintName: "FK_7iq8wfwh6nrr9x0x8555uk4ux", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-41") {
		addForeignKeyConstraint(baseColumnNames: "owner_id", baseTableName: "repository", constraintName: "FK_3f4oefeff08pojy6d4l9g8u0w", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-42") {
		addForeignKeyConstraint(baseColumnNames: "repository_id", baseTableName: "repository_teams", constraintName: "FK_hlynhccq3d68bfhjhe8ib64jx", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "repository", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-43") {
		addForeignKeyConstraint(baseColumnNames: "team_id", baseTableName: "repository_teams", constraintName: "FK_n3iouff4fijanf9pbqt0699ss", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "team", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-44") {
		addForeignKeyConstraint(baseColumnNames: "team_members_id", baseTableName: "team_user", constraintName: "FK_jfn44gpqsb8d76rrmty0sh83d", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "team", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-45") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "team_user", constraintName: "FK_f9m3vjnh6u5yg0l0epna2kla8", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-46") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK_it77eq964jhfqtu54081ebtio", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474701699808-47") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK_apcc8lxk2xnug8377fatvbn04", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}
}
