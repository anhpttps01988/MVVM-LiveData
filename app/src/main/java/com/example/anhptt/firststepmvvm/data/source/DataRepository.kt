package com.example.anhptt.firststepmvvm.data.source

import com.example.anhptt.firststepmvvm.common.di.scopes.Local
import com.example.anhptt.firststepmvvm.common.di.scopes.Remote
import javax.inject.Inject

class DataRepository @Inject constructor(@Local local: DataSource, @Remote remote: DataSource) : DataSource {

}