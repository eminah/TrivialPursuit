package edu.chl.TrivialPursuit;

import edu.chl.TrivialPursuit.view.ProjectView;
import edu.chl.TrivialPursuit.controller.ProjectController;
import edu.chl.TrivialPursuit.model.Project;

import javax.swing.SwingUtilities;

/*
  Application entry class (if using standard java and Swing)
*/
public final class Main {
	private Main() {
		/* No instances allowed! */
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
                    final Project project = new Project();
                    final ProjectView projectView = new ProjectView(project);
                    
                    ProjectController.create(project, projectView);
                    projectView.setVisible(true);
                });
	}
}
