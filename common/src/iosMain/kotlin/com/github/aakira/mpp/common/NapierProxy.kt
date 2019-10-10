package com.github.aakira.mpp.common

import com.github.aakira.napier.DebugAntilog
import com.github.aakira.napier.Napier

fun debugBuild() {
    Napier.base(DebugAntilog())
}