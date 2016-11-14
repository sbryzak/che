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
package org.eclipse.che.ide.api.command;

import org.eclipse.che.api.promises.client.Promise;
import org.eclipse.che.ide.api.resources.Project;

import java.util.List;
import java.util.Map;

/**
 * Facade for command related operations.
 *
 * @author Artem Zatsarynnyi
 */
public interface CommandManager3 {

    /** Returns workspace commands. */
    List<CommandWithContext> getCommands();

    Promise<CommandWithContext> createCommand(String type, ApplicableContext applicableContext);

    /**
     * Creates new command of the specified type.
     * <p><b>Note</b> that command's name will be generated by {@link CommandManager3}
     * and command line will be provided by an appropriate {@link CommandType}.
     */
    Promise<CommandImpl> createWorkspaceCommand(String type);

    /**
     * Creates new command with the specified arguments.
     * <p><b>Note</b> that name of the created command may differ from
     * the specified {@code desirableName} in order to prevent name duplication.
     */
    Promise<CommandImpl> createWorkspaceCommand(String desirableName, String commandLine, String type, Map<String, String> attributes);

    /**
     * Updates the command with the specified {@code name} by replacing it with the given {@code command}.
     * <p><b>Note</b> that name of the updated command may differ from the name provided by the given {@code command}
     * in order to prevent name duplication.
     */
    Promise<CommandImpl> updateWorkspaceCommand(String name, CommandImpl command);

    /** Removes the workspace command with the specified {@code commandName}. */
    Promise<Void> removeCommand(String commandName);

    /** Returns project commands. */
    List<CommandImpl> getProjectCommands(Project project);

    Promise<CommandImpl> createProjectCommand(Project project, String type);

    Promise<CommandImpl> createProjectCommand(Project project,
                                              String desirableName,
                                              String commandLine,
                                              String type,
                                              Map<String, String> attributes);

    Promise<CommandImpl> updateProjectCommand(Project project, String commandName, CommandImpl command);

    /** Removes the project command with the specified {@code name}. */
    Promise<Void> removeProjectCommand(Project project, String name);

    /** Returns the pages for editing command of the specified {@code type}. */
    List<CommandPage> getPages(String type);

    void addCommandChangedListener(CommandChangedListener listener);

    void removeCommandChangedListener(CommandChangedListener listener);

    /** Listener that will be called when command has been changed. */
    interface CommandChangedListener {
        void onCommandAdded(CommandImpl command);

        void onCommandUpdated(CommandImpl command);

        void onCommandRemoved(CommandImpl command);
    }
}
