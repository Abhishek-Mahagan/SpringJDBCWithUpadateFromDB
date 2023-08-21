package com.mahagan.dao;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;

public class ProjectDao {
    private DataSource dataSource;
    private ProjectSqlUpadate projectsqlUpadate;
    private final String QUERY_ME="Update inset set email=? where id=?";


    public ProjectDao(DataSource dataSource) {
        this.dataSource = dataSource;
        projectsqlUpadate=new ProjectSqlUpadate(dataSource,QUERY_ME);
       /* public int UpdateProjects(int projectNo,String title)
        {
            return projectSqlUpadate.update(new Object[]{title,projectNo});
        }*/
    }
    public int UpdateProjects(int id,String email)
    {
        return projectsqlUpadate.update(new Object[]{email,id});
    }
    private final class ProjectSqlUpadate extends SqlUpdate
    {
        public ProjectSqlUpadate(DataSource dataSource1, String sqlpass)
        {
            super(dataSource1,sqlpass);
            declareParameter(new SqlParameter(java.sql.Types.VARCHAR));
            declareParameter(new SqlParameter(java.sql.Types.INTEGER));


            compile();

        }
    }
}
