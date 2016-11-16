/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.ide.command.editor;

import com.google.inject.Inject;
import com.google.inject.Provider;

import org.eclipse.che.ide.api.editor.EditorPartPresenter;
import org.eclipse.che.ide.api.editor.EditorProvider;

/**
 * //
 *
 * @author Artem Zatsarynnyi
 */
public class CommandEditorProvider implements EditorProvider {

    private final Provider<CommandEditor> editorProvider;

    @Inject
    public CommandEditorProvider(Provider<CommandEditor> editorProvider) {
        this.editorProvider = editorProvider;
    }

    @Override
    public String getId() {
        return "che_command_editor";
    }

    @Override
    public String getDescription() {
        return "Che command editor";
    }

    @Override
    public EditorPartPresenter getEditor() {
        return editorProvider.get();
    }
}