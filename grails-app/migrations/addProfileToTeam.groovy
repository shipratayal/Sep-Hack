databaseChangeLog = {

	changeSet(author: "nakul (generated)", id: "1474697659892-1") {
		addColumn(tableName: "team") {
			column(name: "team_profile", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}



	changeSet(author: "nakul (generated)", id: "1474697659892-4") {
		modifyDataType(columnName: "description", newDataType: "text", tableName: "repository")
	}
}
