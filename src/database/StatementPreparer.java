package database;

import java.sql.PreparedStatement;

@FunctionalInterface
public interface StatementPreparer {
	public void prepare(PreparedStatement preparedStatement);
	
}
