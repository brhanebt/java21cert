package designpatterns.creational.builder;


interface IQueryBuilder{
	IQueryBuilder select(String[] columns);
	IQueryBuilder from(String table);
	IQueryBuilder join(String table, String condition);
	IQueryBuilder where(String condition);
	IQueryBuilder orderBy(String column);
	IQueryBuilder groupBy(String column);
	IQueryBuilder having(String condition);
	IQueryBuilder limit(int limit);
	IQueryBuilder offset(int offset);
	String build();
}

class QueryBuilder implements IQueryBuilder{
    private StringBuilder query;

    public QueryBuilder() {
        this.query = new StringBuilder();
    }

    public static IQueryBuilder builder() {
        return new QueryBuilder();
    }

    @Override
    public IQueryBuilder select(String[] columns) {
        query.append("SELECT ");
        for(int i=0; i<columns.length; i++) {
            query.append(columns[i]);
            if(i != columns.length - 1) {
                query.append(", ");
            }
        }
        return this;
    }

    @Override
    public IQueryBuilder from(String table) {
        query.append(" FROM ").append(table);
        return this;
    }

    @Override
    public IQueryBuilder join(String table, String condition) {
        query.append(" JOIN ").append(table).append(" ON ").append(condition);
        return this;
    }

    @Override
    public IQueryBuilder where(String condition) {
        query.append(" WHERE ").append(condition);
        return this;
    }

    @Override
    public IQueryBuilder orderBy(String column) {
        query.append(" ORDER BY ").append(column);
        return this;
    }

    @Override
    public IQueryBuilder groupBy(String column) {
        query.append(" GROUP BY ").append(column);
        return this;
    }

    @Override
    public IQueryBuilder having(String condition) {
        query.append(" HAVING ").append(condition);
        return this;
    }

    @Override
    public IQueryBuilder limit(int limit) {
        query.append(" LIMIT ").append(limit);
        return this;
    }

    @Override
    public IQueryBuilder offset(int offset) {
        query.append(" OFFSET ").append(offset);
        return this;
    }

    @Override
    public String build() {
        return query.toString();
    }
}

public class SqlQueryBuilder {
    public static void main(String[] args) {
    	IQueryBuilder builder = QueryBuilder.builder();
        String query = builder.select(new String[]{"name", "age"})
                              .from("users")
                              .where("age > 18")
                              .orderBy("name")
                              .build();
        System.out.println(query);
    }
}