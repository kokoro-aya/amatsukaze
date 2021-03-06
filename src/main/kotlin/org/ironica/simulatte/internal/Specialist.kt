/*
 * Copyright (c) 2020-2021. kokoro-aya. All right reserved.
 * Simulatte - A Playground Server implemented with Kotlin DSL
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or any later version.
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License along with this program. If not, see <https://www.gnu.org/licenses/>.
 *
 */

package org.ironica.simulatte.internal

import org.ironica.simulatte.manager.AbstractManager
import org.ironica.simulatte.playground.Color

/**
 * Concrete Specialist class that inherits the implementations in Character trait.
 * The primary constructor has only id so each Specialist is distinguished by its id.
 * And the secondary constructor allow us to inject the manager into it.
 * Note that the Character trait doesn't implement features such as `turnLockUp`, they are implemented here.
 */
data class Specialist(override val id: Int): Character {

    override var manager: AbstractManager? = null

    constructor(manager: AbstractManager, id: Int): this(id) {
        this.manager = manager
    }

    val isBeforeLock: Boolean
        get() = manager?.isBeforeLock(id) ?: throw NullPointerException("Specialist:: uninitialized character")

    fun turnLockUp() {
        manager?.turnLockUp(id) ?: throw NullPointerException("Specialist:: uninitialized character")
    }

    fun turnLockDown() {
        manager?.turnLockDown(id) ?: throw NullPointerException("Specialist:: uninitialized character")
    }
}