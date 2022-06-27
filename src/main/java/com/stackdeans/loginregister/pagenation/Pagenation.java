package com.stackdeans.loginregister.pagenation;

import com.stackdeans.loginregister.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

public class Pagenation implements Page<Product> {
    @Override
    public int getTotalPages() {
        return 0;
    }

    @Override
    public long getTotalElements() {
        return 0;
    }

    @Override
    public int getNumber() {
        return 0;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public int getNumberOfElements() {
        return 0;
    }

    @Override
    public List<Product> getContent() {
        return null;
    }

    @Override
    public boolean hasContent() {
        return false;
    }

    @Override
    public Sort getSort() {
        return null;
    }

    @Override
    public boolean isFirst() {
        return false;
    }

    @Override
    public boolean isLast() {
        return false;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public Pageable getPageable() {
        return Page.super.getPageable();
    }

    @Override
    public Pageable nextPageable() {
        return null;
    }

    @Override
    public Pageable previousPageable() {
        return null;
    }

    @Override
    public <U> Page<U> map(Function<? super Product, ? extends U> converter) {
        return null;
    }

    @Override
    public List<Product> toList() {
        return Page.super.toList();
    }

    @Override
    public Set<Product> toSet() {
        return Page.super.toSet();
    }

    @Override
    public Stream<Product> get() {
        return Page.super.get();
    }

    @Override
    public Pageable nextOrLastPageable() {
        return Page.super.nextOrLastPageable();
    }

    @Override
    public Pageable previousOrFirstPageable() {
        return Page.super.previousOrFirstPageable();
    }

    @Override
    public Iterator<Product> iterator() {
        return null;
    }
}
