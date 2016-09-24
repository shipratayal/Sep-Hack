databaseChangeLog = {

	changeSet(author: "nakul (generated)", id: "1474697300526-1") {
		addColumn(tableName: "user") {
			column(name: "first_name", type: "varchar(12)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "nakul (generated)", id: "1474697300526-2") {
		addColumn(tableName: "user") {
			column(name: "last_name", type: "varchar(12)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "nakul (generated)", id: "1474697300526-3") {
		modifyDataType(columnName: "description", newDataType: "text", tableName: "repository")
	}
}
