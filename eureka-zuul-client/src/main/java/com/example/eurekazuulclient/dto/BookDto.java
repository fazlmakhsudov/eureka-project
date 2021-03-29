package com.example.eurekazuulclient.dto;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author Fazliddin Makhsudov
 * @version 1.0
 * @date 29.03.21 21:00
 */
public class BookDto {

    private Long id;

    @NotNull
    private String name;

    public BookDto() {
    }

    public BookDto(@NotNull String name) {
        this.name = name;
    }

    public BookDto(Long id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return Objects.equals(id, bookDto.id) && Objects.equals(name, bookDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
