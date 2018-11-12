package sc.dinero.webfunds.talisman.model.database

import android.os.HandlerThread

class DbWorkerThread(threadName : String) : HandlerThread(threadName) {}