package com.suntiago.filterviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.suntiago.filter.FilterData;
import com.suntiago.filter.FilterView;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;


public class MainActivity extends AppCompatActivity {

    List<FilterData> mFilterDataList = new ArrayList<>();
    TextView provinceChose;
    TextView searchChose;
    FilterView filterViewProvince;
    FilterView mPromoteSearch1;
    FilterView mPromoteSearch2;
    FilterView mPromoteSearch3;
    private String[] mProvinces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        provinceChose = (TextView) findViewById(R.id.province_filter_chose);
        searchChose = (TextView) findViewById(R.id.promote_search_chose);

        //省份选择
        filterViewProvince = (FilterView) findViewById(R.id.province_filter);
        filterViewProvince.setMultiSelect(false);
        filterViewProvince.setNotNull(false);
        if (mProvinces == null) {
            mProvinces = getResources().getStringArray(R.array.province_array);
        }
        for (String province : mProvinces) {
            mFilterDataList.add(new FilterData(province, province));
        }
        filterViewProvince.initData(mFilterDataList, null);
        filterViewProvince.setOnItemClick(new FilterView.OnItemClick() {
            @Override
            public void onClick(boolean b, FilterData data) {
                Toast.makeText(MainActivity.this, data.getValue(), LENGTH_SHORT);
            }
        });
        filterViewProvince.setOnItemClick(new FilterView.OnItemClick() {
            @Override
            public void onClick(boolean b, FilterData data) {
                List<FilterData> filterDatas = filterViewProvince.getChoseFilter().getList();
                String s = "";
                if (filterDatas != null) {
                    for (FilterData filterData : filterDatas) {
                        s += filterData.getName() + ":" + filterData.getValue() + "\n";
                    }
                }
                provinceChose.setText(s);
            }
        });

        mPromoteSearch1 = (FilterView) findViewById(R.id.promote_search1);
        mPromoteSearch2 = (FilterView) findViewById(R.id.promote_search2);
        mPromoteSearch3 = (FilterView) findViewById(R.id.promote_search3);
        List<FilterData> data1 = new ArrayList<FilterData>();
        List<FilterData> data2 = new ArrayList<FilterData>();
        List<FilterData> data3 = new ArrayList<FilterData>();

        FilterData ptitle = new FilterData("分类", "title1", FilterData.TITLE);
        FilterData p1 = new FilterData("电器", "aaa1", FilterData.VALUE);
        FilterData p2 = new FilterData("零食", "bbb1", FilterData.VALUE);
        FilterData p3 = new FilterData("书籍", "ccc1", FilterData.VALUE);
        FilterData p4 = new FilterData("运动器材", "ddd1", FilterData.VALUE);
        FilterData p5 = new FilterData("无", "eee", FilterData.VALUE);

        FilterData ptitle1 = new FilterData("价格", "title2", FilterData.TITLE);
        FilterData p11 = new FilterData("100$", "aaa2", FilterData.VALUE);
        FilterData p21 = new FilterData("50$", "bbb2", FilterData.VALUE);
        FilterData p31 = new FilterData("20$", "ccc2", FilterData.VALUE);
        FilterData p41 = new FilterData("10$", "ddd2", FilterData.VALUE);
        FilterData p51 = new FilterData("0&", "eee2", FilterData.VALUE);

        FilterData ptitle2 = new FilterData("品牌", "title3", FilterData.TITLE);
        FilterData p12 = new FilterData("nike", "aaa3", FilterData.VALUE);
        FilterData p22 = new FilterData("ads", "bbb3", FilterData.VALUE);
        FilterData p32 = new FilterData("lining", "ccc3", FilterData.VALUE);
        FilterData p42 = new FilterData("回力", "ddd3", FilterData.VALUE);
        FilterData p52 = new FilterData("乔丹", "eee3", FilterData.VALUE);

        data1.add(ptitle);
        data1.add(p1);
        data1.add(p2);
        data1.add(p3);
        data1.add(p4);
        data1.add(p5);
        data2.add(ptitle1);
        data2.add(p11);
        data2.add(p21);
        data2.add(p31);
        data2.add(p41);
        data2.add(p51);

        data3.add(ptitle2);
        data3.add(p12);
        data3.add(p22);
        data3.add(p32);
        data3.add(p42);
        data3.add(p52);
        mPromoteSearch1.initData(data1, null);
        mPromoteSearch2.initData(data2, null);
        mPromoteSearch3.initData(data3, null);
        mPromoteSearch1.setOnItemClick(new FilterView.OnItemClick() {
            @Override
            public void onClick(boolean b, FilterData data) {
                set();
            }
        });
        mPromoteSearch2.setOnItemClick(new FilterView.OnItemClick() {
            @Override
            public void onClick(boolean b, FilterData data) {
                set();
            }
        });
        mPromoteSearch3.setOnItemClick(new FilterView.OnItemClick() {
            @Override
            public void onClick(boolean b, FilterData data) {
                set();
            }
        });
    }

    public void set() {
        String s = "";
        List<FilterData> filterDatas = mPromoteSearch1.getChoseFilter().getList();
        if (filterDatas != null) {
            for (FilterData filterData : filterDatas) {
                s += filterData.getName() + ":" + filterData.getValue() + "\n";
            }
        }
        filterDatas = mPromoteSearch2.getChoseFilter().getList();
        if (filterDatas != null) {
            for (FilterData filterData : filterDatas) {
                s += filterData.getName() + ":" + filterData.getValue() + "\n";
            }
        }
        filterDatas = mPromoteSearch3.getChoseFilter().getList();
        if (filterDatas != null) {
            for (FilterData filterData : filterDatas) {
                s += filterData.getName() + ":" + filterData.getValue() + "\n";
            }
        }
        searchChose.setText(s);
    }
}


