package csc301.ultrasound.frontend.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import csc301.ultrasound.model.User;
import csc301.ultrasound.global.Authentication;
import csc301.ultrasound.global.Constants;

/**
 * Creates a window where a user can authenticate themselves.
 */
public class Login extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	/** The authenticated user */
	private User user = null;

	/**
	 * Create the log-in window.
	 */
	public Login()
	{
		this.setTitle("Login");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 474, 343);

		JPanel contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("",
				"[-3.00][][][30.00][44.00][83.00,grow][38.00][][][]",
				"[][][][][][][][][][]"));

		JLabel userNameLbl = new JLabel("Username:");
		contentPane.add(userNameLbl, "cell 4 1");

		final JFormattedTextField userNameTf = new JFormattedTextField();
		contentPane.add(userNameTf, "cell 4 2 3 1,growx");

		JLabel pWLbl = new JLabel("Password:");
		contentPane.add(pWLbl, "cell 4 4");

		final JPasswordField passwordTf = new JPasswordField();
		passwordTf.setActionCommand("Log in");
		contentPane.add(passwordTf, "cell 4 5 3 1,growx");

		JButton login = new JButton("Log in");
		this.getRootPane().setDefaultButton(login);
		
		login.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				Authentication auth = new Authentication();
				
				String username     = userNameTf.getText();
				String userPassword = new String(passwordTf.getPassword());
				
				user = auth.authenticate(username, userPassword);
				
				if (username == null || username.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Username cannot be empty!", "Login Failure!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				if (userPassword == null || userPassword.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Password cannot be empty!", "Login Failure!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				// A username and password was entered, but the user is still not authenicated. Their password and/or username must be wrong.
				if (user == null)
				{
					JOptionPane.showMessageDialog(null, "Incorrect username and/or password.", "Login Failure!", JOptionPane.ERROR_MESSAGE);
					return;
				}
				else	// authenticated properly
				{
					// prevent any authlevel greater than radiologists (fieldworkers) to access the system
					if (user.getAuthlevel() > Constants.AUTHLEVEL_RADIOLOGIST)
					{
						JOptionPane.showMessageDialog(null, "You do not have the necessary permissions to access.", "Login Failure!", JOptionPane.ERROR_MESSAGE);
						return;
					}	
					else	// log in
					{
						//JOptionPane.showMessageDialog(null, String.format("Authenticated. Hello %s.", user.getName()), "Login Success!", JOptionPane.INFORMATION_MESSAGE);
						dispose();
						return;
					}
				}
			}
		});
		
		contentPane.add(login, "cell 3 8 3 1");

		JButton cancel = new JButton("Cancel");
		
		cancel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
				dispose();
			}
		});

		contentPane.add(cancel, "cell 6 8 2 1");

		this.pack();
		
		Util.centerWindow(this);
		
		this.setVisible(true);
	}

	/**
	 * Returns the authenticated user.
	 *
	 * @return The authenticated user.
	 */
	public User getUser()
	{
		return user;
	}
}
