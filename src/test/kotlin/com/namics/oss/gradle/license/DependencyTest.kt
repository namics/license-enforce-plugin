/**
 * MIT License
 *
 * Copyright (c) 2019 Namics AG
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.namics.oss.gradle.license

import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.test.Test

/**
 * DependencyTest.
 *
 * @author aschaefer, Namics AG
 * @since 2019-05-06 14:49
 */
class DependencyTest {
    @Test
    fun matchesWIthoutVersion() {
        assertTrue(Dependency("hello:world:1.2.3", emptyList()).matches(Dependency("hello:world:1.2.3", emptyList())))
        assertTrue(Dependency("hello:world:1.2.3", emptyList()).matches(Dependency("hello:world", emptyList())))
    }

    @Test
    fun matchesNoMatch() {
        assertFalse(Dependency("hello:world:1.2.3", emptyList()).matches(Dependency("hello:worlds:1.2.3", emptyList())))
        assertFalse(Dependency("hello:world:1.2.3", emptyList()).matches(Dependency("hello:1.2.3", emptyList())))
        assertFalse(Dependency("hello:world:1.2.3", emptyList()).matches(Dependency("", emptyList())))
    }

}
