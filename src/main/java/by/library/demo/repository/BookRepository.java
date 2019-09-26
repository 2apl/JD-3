package by.library.demo.repository;

import java.util.List;

import by.library.demo.dto.ResultDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    public BookRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ResultDto> getResult(List<String> selectedAuthors, List<String> selectedGenres, Integer yearFrom, Integer yearTo) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("authors", selectedAuthors);
        parameterSource.addValue("genres", selectedGenres);
        parameterSource.addValue("yearFrom", yearFrom);
        parameterSource.addValue("yearTo", yearTo);

        String query = "SELECT book.name, book.creation_year, author.name, genre.name " +
                "FROM ((library.book LEFT OUTER JOIN library.author ON book.author_id = author.id) JOIN library.genre ON book.genre_id = genre.id)" +
                "WHERE author_id IN (SELECT id FROM library.author WHERE author.name IN (:authors)) " +
                "AND genre_id IN (SELECT id FROM library.genre WHERE genre.name IN (:genres)) " +
                "AND creation_year BETWEEN :yearFrom AND :yearTo ";
        List<ResultDto> resultDtos = namedParameterJdbcTemplate.query(query, parameterSource, (it, row) -> new ResultDto(
                it.getString(1),
                it.getInt(2),
                it.getString(3),
                it.getString(4)
        ));

        return resultDtos;
    }

    public List<String> findAllAuthors() {
        String query = "SELECT name FROM library.author";
        return jdbcTemplate.queryForList(query, String.class);
    }

    public List<String> findAllGenres() {
        String query = "SELECT name FROM library.genre";
        return jdbcTemplate.queryForList(query, String.class);
    }
}
