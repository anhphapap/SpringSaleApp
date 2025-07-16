package com.pap.services;

import java.util.List;

public interface StatsService {
    List<Object[]> statsRevenueByProduct();
    List<Object[]> statsRevenueByTime(String time, int year);
}
