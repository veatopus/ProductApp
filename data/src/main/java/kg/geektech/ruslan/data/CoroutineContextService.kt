package kg.geektech.ruslan.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

fun provideCoroutineContext(job: Job) : CoroutineContext = Dispatchers.Main + job

fun provideJob(): Job = Job()