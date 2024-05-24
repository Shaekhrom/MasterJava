package com.curso.service;

import java.util.List;

public interface PasteleriaService {
    long countBizcochos();
    double percentageVeganos();
    List<String> countBizcochosByRepostero();
    long countReposterosByAgeBetween20And30();
    double averageSalary();
}
