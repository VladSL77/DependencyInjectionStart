package com.example.dependencyinjectionstart.example2.data.datasource

import android.util.Log
import javax.inject.Inject

class TestExampleRemoteDataSourceImpl @Inject constructor() : ExampleRemoteDataSource {

    override fun method() {
        Log.d("EXAMPLE_TEST", "TestExampleRemoteDataSourceImpl")
    }
}
