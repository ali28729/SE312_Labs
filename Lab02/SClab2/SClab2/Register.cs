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
    public partial class Register : Form
    {
        public Register()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox1.Text == "" || textBox2.Text == "" || textBox3.Text == "")
            {
                MessageBox.Show("Please provide UserName, Password and Email!");
                return;
            }
            string email = textBox1.Text;
            string pass = textBox3.Text;
            string name = textBox2.Text;

            string connectionString = "datasource=127.0.0.1;port=3306;username=root;password=;database=LMS;";
            MySqlConnection databaseConnection = new MySqlConnection(connectionString);

            try
            {
                String query = "INSERT INTO user (userName,userPassword,userEmail) VALUES (@userName,@userPassword, @userEmail)";
                using (MySqlCommand command = new MySqlCommand(query, databaseConnection))
                {
                    command.CommandTimeout = 60;
                    command.Parameters.AddWithValue("@userName", textBox2.Text);
                    command.Parameters.AddWithValue("@userPassword", textBox3.Text);
                    command.Parameters.AddWithValue("@userEmail", textBox1.Text);

                    databaseConnection.Open();
                    int result = command.ExecuteNonQuery();

                    // Check Error
                    if (result < 0)
                        Console.WriteLine("Error inserting data into Database!");
                    else
                    {
                        label4.Show();
                    }
                    databaseConnection.Close();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }

        private void Register_Load(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }
    }
}
