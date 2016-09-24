databaseChangeLog = {

	changeSet(author: "vijay (generated)", id: "1474700480253-1") {
		modifyDataType(columnName: "description", newDataType: "text", tableName: "issue")
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-2") {
		modifyDataType(columnName: "description", newDataType: "text", tableName: "repository")
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-23") {
		createIndex(indexName: "FK_fkma8athhaxpg7814w6s80yh7", tableName: "attachments") {
			column(name: "issue_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-24") {
		createIndex(indexName: "FK_hlgd3nqmn1mopr4ait0254eas", tableName: "attachments") {
			column(name: "comment_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-25") {
		createIndex(indexName: "FK_kyjvp1i6gbv9vtp2tpwy8qxc1", tableName: "comment") {
			column(name: "commented_by_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-26") {
		createIndex(indexName: "FK_9to8qh3or7i1hr3w2fdag0kd3", tableName: "comment_user") {
			column(name: "comment_notifies_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-27") {
		createIndex(indexName: "FK_obutvg4o609wp066ipmoky7ar", tableName: "comment_user") {
			column(name: "user_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-28") {
		createIndex(indexName: "FK_73kl4d88gc5ct5iq6blo13ow4", tableName: "issue") {
			column(name: "project_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-29") {
		createIndex(indexName: "FK_ixka0fo05tgbfn5edwgcby3fs", tableName: "issue") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-30") {
		createIndex(indexName: "FK_p7ryfojxujwurm7tblcks6035", tableName: "issue") {
			column(name: "mile_stone_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-31") {
		createIndex(indexName: "FK_4r9jve2lvb0cowupc1fxey59q", tableName: "issue_comment") {
			column(name: "comment_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-32") {
		createIndex(indexName: "FK_a9ju9l6tw1psjodvxqo1ksnwi", tableName: "issue_comment") {
			column(name: "issue_comments_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-33") {
		createIndex(indexName: "FK_bq8ko2fisw0ntm2x1837inou4", tableName: "issue_label") {
			column(name: "issue_labels_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-34") {
		createIndex(indexName: "FK_g25qu9af5rxkj15kyjxlxn6gr", tableName: "issue_label") {
			column(name: "label_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-35") {
		createIndex(indexName: "FK_5uj41kx9aw7cnord2l42a6bu5", tableName: "issue_user") {
			column(name: "user_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-36") {
		createIndex(indexName: "FK_6kx9j11hgl98alpy241a8cdi8", tableName: "issue_user") {
			column(name: "issue_assignees_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-37") {
		createIndex(indexName: "FK_apdwyj7kq5egsd8k8h4li1n5o", tableName: "label") {
			column(name: "repository_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-38") {
		createIndex(indexName: "FK_sdso6jye4bg8wtscpoxxn7kf6", tableName: "mile_stone") {
			column(name: "repository_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-39") {
		createIndex(indexName: "FK_6imf4pimjkp0ifsm9elywa7h", tableName: "notification") {
			column(name: "created_by_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-40") {
		createIndex(indexName: "FK_54ptemgd0wicq8djc1dsycy5", tableName: "notification_user") {
			column(name: "notification_notify_to_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-41") {
		createIndex(indexName: "FK_7iq8wfwh6nrr9x0x8555uk4ux", tableName: "notification_user") {
			column(name: "user_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-42") {
		createIndex(indexName: "FK_i0u1b2bm0gfnca9cbyt0gmcip", tableName: "notification_user") {
			column(name: "notification_read_by_id")
		}
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-3") {
		addForeignKeyConstraint(baseColumnNames: "comment_id", baseTableName: "attachments", constraintName: "FK_hlgd3nqmn1mopr4ait0254eas", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "comment", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-4") {
		addForeignKeyConstraint(baseColumnNames: "issue_id", baseTableName: "attachments", constraintName: "FK_fkma8athhaxpg7814w6s80yh7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "issue", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-5") {
		addForeignKeyConstraint(baseColumnNames: "commented_by_id", baseTableName: "comment", constraintName: "FK_kyjvp1i6gbv9vtp2tpwy8qxc1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-6") {
		addForeignKeyConstraint(baseColumnNames: "comment_notifies_id", baseTableName: "comment_user", constraintName: "FK_9to8qh3or7i1hr3w2fdag0kd3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "comment", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-7") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "comment_user", constraintName: "FK_obutvg4o609wp066ipmoky7ar", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-8") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "issue", constraintName: "FK_ixka0fo05tgbfn5edwgcby3fs", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-9") {
		addForeignKeyConstraint(baseColumnNames: "mile_stone_id", baseTableName: "issue", constraintName: "FK_p7ryfojxujwurm7tblcks6035", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "mile_stone", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-10") {
		addForeignKeyConstraint(baseColumnNames: "project_id", baseTableName: "issue", constraintName: "FK_73kl4d88gc5ct5iq6blo13ow4", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "repository", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-11") {
		addForeignKeyConstraint(baseColumnNames: "comment_id", baseTableName: "issue_comment", constraintName: "FK_4r9jve2lvb0cowupc1fxey59q", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "comment", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-12") {
		addForeignKeyConstraint(baseColumnNames: "issue_comments_id", baseTableName: "issue_comment", constraintName: "FK_a9ju9l6tw1psjodvxqo1ksnwi", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "issue", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-13") {
		addForeignKeyConstraint(baseColumnNames: "issue_labels_id", baseTableName: "issue_label", constraintName: "FK_bq8ko2fisw0ntm2x1837inou4", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "issue", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-14") {
		addForeignKeyConstraint(baseColumnNames: "label_id", baseTableName: "issue_label", constraintName: "FK_g25qu9af5rxkj15kyjxlxn6gr", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "label", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-15") {
		addForeignKeyConstraint(baseColumnNames: "issue_assignees_id", baseTableName: "issue_user", constraintName: "FK_6kx9j11hgl98alpy241a8cdi8", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "issue", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-16") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "issue_user", constraintName: "FK_5uj41kx9aw7cnord2l42a6bu5", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-17") {
		addForeignKeyConstraint(baseColumnNames: "repository_id", baseTableName: "label", constraintName: "FK_apdwyj7kq5egsd8k8h4li1n5o", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "repository", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-18") {
		addForeignKeyConstraint(baseColumnNames: "repository_id", baseTableName: "mile_stone", constraintName: "FK_sdso6jye4bg8wtscpoxxn7kf6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "repository", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-19") {
		addForeignKeyConstraint(baseColumnNames: "created_by_id", baseTableName: "notification", constraintName: "FK_6imf4pimjkp0ifsm9elywa7h", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-20") {
		addForeignKeyConstraint(baseColumnNames: "notification_notify_to_id", baseTableName: "notification_user", constraintName: "FK_54ptemgd0wicq8djc1dsycy5", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "notification", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-21") {
		addForeignKeyConstraint(baseColumnNames: "notification_read_by_id", baseTableName: "notification_user", constraintName: "FK_i0u1b2bm0gfnca9cbyt0gmcip", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "notification", referencesUniqueColumn: "false")
	}

	changeSet(author: "vijay (generated)", id: "1474700480253-22") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "notification_user", constraintName: "FK_7iq8wfwh6nrr9x0x8555uk4ux", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}
}
