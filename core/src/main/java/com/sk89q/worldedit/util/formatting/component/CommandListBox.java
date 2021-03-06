/*
 * WorldEdit, a Minecraft world manipulation toolkit
 * Copyright (C) sk89q <http://www.sk89q.com>
 * Copyright (C) WorldEdit team and contributors
 *
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.sk89q.worldedit.util.formatting.component;

import com.boydti.fawe.config.BBC;

public class CommandListBox extends MessageBox {

    private boolean first = true;

    /**
     * Create a new box.
     *
     * @param title the title
     */
    public CommandListBox(String title) {
        super(title);
    }

    public static Class<?> inject() {
        return CommandListBox.class;
    }

    public CommandListBox appendCommand(String alias, String description) {
        return appendCommand(alias, description, true);
    }

    public CommandListBox appendCommand(String alias, String description, boolean allowed) {
        if (!first) {
            getContents().newLine();
        }
        getContents().append((allowed ? BBC.HELP_ITEM_ALLOWED : BBC.HELP_ITEM_DENIED).format(alias, description));
        first = false;
        return this;
    }
}
