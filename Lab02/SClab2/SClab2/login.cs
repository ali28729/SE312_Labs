using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MySql.Data.MySqlClient;

namespace SClab2
{
    public partial class login : Form
    {
        public Dashboard dash;
        public login(Dashboard d1)
        {
            InitializeComponent();
            dash = d1;
        }

        private void login_Load(object sender, EventArgs e)
        {

        }

        private void pass_TextChanged(object sender, EventArgs e)
        {
            unf.Hide();
        }

        private void button1_Click(object sender, EventArgs e)
        {

            if (email.Text == "" || pass.Text == "")
            {
                MessageBox.Show("Please Provide Email Address and Password!");
                return;
            }

            string connectionString = "datasource=127.0.0.1;port=3306;username=root;password=;database=LMS;";
            string query = "Select * From user where userPassword='" + pass.Text + "'and userEmail='" + email.Text +"'";

            try
            {
                MySqlConnection databaseConnection = new MySqlConnection(connectionString);
                MySqlCommand commandDatabase = new MySqlCommand(query, databaseConnection);
                commandDatabase.CommandTimeout = 60;
                MySqlDataReader reader;

                databaseConnection.Open();
                reader = commandDatabase.ExecuteReader();

                if (reader.HasRows)
                {
                    
                    dash.logout.Show();
                    dash.registeration.Hide();
                    dash.button1.Hide();
                    this.Hide();
                    dash.tabAllRecords.TabPages.Add(dash.issue);

                }
                else
                {
                    Console.WriteLine("User Not Found!");
                    unf.Show();
                }
                databaseConnection.Close();


            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void email_TextChanged(object sender, EventArgs e)
        {
            unf.Hide();
        }
    }
}
