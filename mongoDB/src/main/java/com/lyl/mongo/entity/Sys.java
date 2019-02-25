package com.lyl.mongo.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author liuyl
 * @date 2018-10-29-11:31
 * @description
 */
public enum Sys {
    /**
     * CSJ
     */
    CSJ() {
        @Override
        public String[] getColumns() {
            return new String[]{"sys","htId","jsId"};
        }
    },
    /**
     * AAA
     */
    AAA() {
        @Override
        public String[] getColumns() {
            return null;
        }
    };

    public abstract  String[] getColumns();

}
