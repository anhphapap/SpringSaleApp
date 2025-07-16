package com.pap.respositories;

import java.util.List;

public interface StatsRespository {
    List<Object[]> statsRevenueByProduct();
    List<Object[]> statsRevenueByTime(String time, int year);
}
