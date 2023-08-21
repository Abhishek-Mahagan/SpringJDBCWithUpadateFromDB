package com.mahagan.dao;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class ProjectDao {
    private DataSource dataSource;
    private ProjectSqlUpadate projectSqlUpadate;

    private final String SQL_FOR_PROJECT="Update project set title=? where projectNo=?";

    public ProjectDao(DataSource dataSource) {
        this.dataSource = dataSource;
        projectSqlUpadate=new  ProjectSqlUpadate(dataSource,SQL_FOR_PROJECT);
    }
    public int UpdateProjects(int projectNo,String title)
    {
        return projectSqlUpadate.update(new Object[]{title,projectNo});
    }

    private final class ProjectSqlUpadate extends SqlUpdate
    {
        public ProjectSqlUpadate(DataSource dataSource1,String sqlquery)
        {
            super(dataSource1,sqlquery);
            declareParameter(new SqlParameter(java.sql.Types.VARCHAR));
            declareParameter(new SqlParameter(java.sql.Types.INTEGER));
            compile();

        }
    }

}
