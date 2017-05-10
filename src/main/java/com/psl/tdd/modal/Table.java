package com.psl.tdd.modal;

import java.util.Set;

public class Table {
	
	private String tableName;
	private Set<Column> columns;
	private String filePath;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Set<Column> getColumns() {
		return columns;
	}

	public void setColumns(Set<Column> columns) {
		this.columns = columns;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Table [tableName=");
		builder.append(tableName);
		builder.append(", columns=");
		builder.append(columns);
		builder.append(", filePath=");
		builder.append(filePath);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
