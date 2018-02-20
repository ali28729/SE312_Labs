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

    public partial class Dashboard : Form
    {
        public int uid = 0;
        public Dashboard()
        {
            InitializeComponent();
            tabAllRecords.TabPages.Remove(login);
        }

        private void allRecordsButton_Click_1(object sender, EventArgs e)
        {
            allRecordsListBox.Items.Clear();
            allArtifacts(); 
        }
        
        private void allArtifacts()
        {
            string connectionString = "datasource=127.0.0.1;port=3306;username=root;password=;database=LMS;";
            string query = "SELECT * FROM artifacts";

            MySqlConnection databaseConnection = new MySqlConnection(connectionString);
            MySqlCommand commandDatabase = new MySqlCommand(query, databaseConnection);
            commandDatabase.CommandTimeout = 60;
            MySqlDataReader reader;

            try
            {
               
                databaseConnection.Open();
                reader = commandDatabase.ExecuteReader();

                if (reader.HasRows)
                {
                    while (reader.Read())
                    {
                        string[] row = { reader.GetString(0), reader.GetString(1), reader.GetString(2), reader.GetString(3), 
                                         reader.GetString(4), reader.GetString(5), reader.GetString(6), reader.GetString(7), reader.GetString(8), reader.GetString(9), reader.GetString(10), };
                        allRecordsListBox.Items.Add(row[0] + ".  " + row[1] + "      " + row[2] + " by " + row[3] + "     " + row[4] + "      " + row[5] + "     " + row[6] + "      " + row[7] + "      " + row[8] + "       " + row[9] + "       " + row[10]);
                      // allRecordsListBox.Items.Add(row[2]);

                    }
                }
                else
                {
                    Console.WriteLine("No rows found.");
                }

                databaseConnection.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }

        }

        private void buttonTitle_Click_1(object sender, EventArgs e)
        {
            listBoxSearch.Controls.Clear();
            listBoxSearch.Items.Clear();
            textBoxGenre.Clear();
            textBoxAuthor.Clear();
            searchByTitle(textBoxTitle.Text);
            
        }

        private void searchByTitle(string a)
        {
            string connectionString = "datasource=127.0.0.1;port=3306;username=root;password=;database=LMS;";
            string query = "select * from artifacts where artName ='" + a + "'";

            MySqlConnection databaseConnection = new MySqlConnection(connectionString);
            MySqlCommand commandDatabase = new MySqlCommand(query, databaseConnection);
            commandDatabase.CommandTimeout = 60;
            MySqlDataReader reader;

            try
            {

                databaseConnection.Open();
                reader = commandDatabase.ExecuteReader();

                if (reader.HasRows)
                {
                    int i = 0, x = 0;
                    while (reader.Read())
                    {
                        string[] row = { reader.GetString(0), reader.GetString(1), reader.GetString(2), reader.GetString(3), 
                                         reader.GetString(4), reader.GetString(5), reader.GetString(6), reader.GetString(7), reader.GetString(8), reader.GetString(9), reader.GetString(10), };
                        listBoxSearch.Items.Add(row[1]+"            "+row[2] + " by " + row[3]  +" is " + row[10]);
                        // allRecordsListBox.Items.Add(row[2]);
                        Button btn = new Button();

                        btn.Location = new Point(600, 0 + x);
                        btn.BackColor = System.Drawing.Color.White;
                        btn.Text = "Issue";
                        btn.Height = 18;
                        btn.Font = new Font(btn.Font.FontFamily, 7);
                        btn.Name = reader.GetString(0);

                        //Hook our button up to our generic button handler
                        btn.Click += new EventHandler(btn_Click);
                        listBoxSearch.Controls.Add(btn);
                        i += 10;
                        x += 20;

                    }
                }
                else
                {
                    Console.WriteLine("No rows found.");
                }

                databaseConnection.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }

        }

        private void buttonGenre_Click(object sender, EventArgs e)
        {
            listBoxSearch.Controls.Clear();
            listBoxSearch.Items.Clear();
            textBoxTitle.Clear();
            textBoxAuthor.Clear();
            searchByGenre(textBoxGenre.Text);
        }

        private void searchByGenre(string a)
        {
            string connectionString = "datasource=127.0.0.1;port=3306;username=root;password=;database=LMS;";
            string query = "select * from artifacts where genre ='" + a + "'";

            MySqlConnection databaseConnection = new MySqlConnection(connectionString);
            MySqlCommand commandDatabase = new MySqlCommand(query, databaseConnection);
            commandDatabase.CommandTimeout = 60;
            MySqlDataReader reader;

            try
            {

                databaseConnection.Open();
                reader = commandDatabase.ExecuteReader();

                if (reader.HasRows)
                {
                    int i = 0;
                    int x = 0;
                    while (reader.Read())
                    {
                        string[] row = { reader.GetString(0), reader.GetString(1), reader.GetString(2), reader.GetString(3), 
                                         reader.GetString(4), reader.GetString(5), reader.GetString(6), reader.GetString(7), reader.GetString(8), reader.GetString(9), reader.GetString(10), };
                        listBoxSearch.Items.Add(row[1] + "\t\t" + row[5] + "\t\t" + row[2] + " by " + row[3] + " is " + row[10]);
                        // allRecordsListBox.Items.Add(row[2]);
                        Button btn = new Button();

                        btn.Location = new Point(600, 0 + x);
                        btn.BackColor = System.Drawing.Color.White;
                        btn.Text = "Issue";
                        btn.Height = 18;
                        btn.Font = new Font(btn.Font.FontFamily, 7);
                        btn.Name = reader.GetString(0);

                        //Hook our button up to our generic button handler
                        btn.Click += new EventHandler(btn_Click);
                        listBoxSearch.Controls.Add(btn);
                        i += 10;
                        x += 20;

                    }
                }
                else
                {
                    Console.WriteLine("No rows found.");
                }

                databaseConnection.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }

        }
        void btn_Click(object sender, EventArgs e)
        {
            int nolim = 3;
            string curart = "";
            string connectionString = "datasource=127.0.0.1;port=3306;username=root;password=;database=LMS;";
            string query = "select * from artifacts where artID ='" + (sender as Button).Name + "'";

            MySqlConnection databaseConnection = new MySqlConnection(connectionString);
            MySqlCommand commandDatabase = new MySqlCommand(query, databaseConnection);
            commandDatabase.CommandTimeout = 60;
            MySqlDataReader reader;

            try
            {
                databaseConnection.Open();
                reader = commandDatabase.ExecuteReader();
                if (reader.HasRows)
                {
                    while (reader.Read())
                    {
                        curart = reader.GetString(1);
                        if (reader.GetString(1) == "Journal")
                            nolim = 2;
                        if (reader.GetString(10) == "available")
                        {
                            databaseConnection.Close();
                            String nolimquery = "SELECT COUNT(glob.artType) FROM (SELECT artifacts.artType, issued.userID FROM artifacts INNER JOIN issued ON artifacts.artID = issued.artID) AS glob WHERE glob.artType = '" + curart + "' AND glob.userID = '" + uid + "';";
                            databaseConnection.Open();
                            using (MySqlCommand nolimcom = new MySqlCommand(nolimquery, databaseConnection))
                            {
                                nolimcom.CommandTimeout = 60;
                                reader = nolimcom.ExecuteReader();
                                if (reader.HasRows)
                                {
                                    while (reader.Read())
                                    {
                                        if (reader.GetInt32(0) >= 3 && curart == "Book")
                                        {
                                            MessageBox.Show("You can't issue more that 3 Books.");
                                            return;
                                        }
                                        else if (reader.GetInt32(0) >= 2 && curart == "Journal")
                                        {
                                            MessageBox.Show("You can't issue more that 2 Journals.");
                                            return;
                                        }

                                    }
                                }
                                else
                                {
                                    Console.WriteLine("No rows found.");
                                }
                                databaseConnection.Close();
                            }


                            string current = DateTime.Now.ToString("yyyy-MM-dd");
                            string onemonth = DateTime.Now.AddMonths(1).ToString("yyyy-MM-dd");
                            string halfmonth = DateTime.Now.AddDays(15).ToString("yyyy-MM-dd");
                            string query1 = "";
                            if (nolim == 3)
                                query1 = "INSERT INTO issued (artID,userID,issueDate,returnDate,fine) VALUES ('" + (sender as Button).Name + "','" + uid + "','" + current + "','" + onemonth + "' ,'" + 0 + "')";

                            else if (nolim == 2)
                                query1 = "INSERT INTO issued (artID,userID,issueDate,returnDate,fine) VALUES ('" + (sender as Button).Name + "','" + uid + "','" + current + "','" + halfmonth + "' ,'" + 0 + "')";
                                
                            databaseConnection.Open();
                            using (MySqlCommand command = new MySqlCommand(query1, databaseConnection))
                            {
                                command.CommandTimeout = 60;
                                int result = command.ExecuteNonQuery();

                                // Check Error
                                if (result < 0)
                                    Console.WriteLine("Error inserting data into Database!");
                                else
                                {
                                    string query2 = "UPDATE artifacts  SET available = 'not available' WHERE artID = '" + (sender as Button).Name + "';";
                                    using (MySqlCommand command1 = new MySqlCommand(query2, databaseConnection))
                                    {
                                        command1.CommandTimeout = 60;
                                        int result1 = command1.ExecuteNonQuery();

                                        // Check Error
                                        if (result1 < 0)
                                            Console.WriteLine("Error inserting data into Database!");
                                        else
                                        {
                                            //MessageBox.Show("Availibilty Updated!");
                                        }
                                        databaseConnection.Close();
                                    }

                                    MessageBox.Show("Resource Issued!");
                                    databaseConnection.Close();
                                    return;
                                }
                            }                            
                        }
                        else
                        {
                            MessageBox.Show("Not Available!");
                        }
                    }
                }
                else
                {
                    Console.WriteLine("No rows found.");
                }

                databaseConnection.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
        }


        private void buttonAuthor_Click(object sender, EventArgs e)
        {
            listBoxSearch.Controls.Clear();
            listBoxSearch.Items.Clear();
            textBoxTitle.Clear();
            textBoxGenre.Clear();
            searchByAuthor(textBoxAuthor.Text);
        }
        
        private void searchByAuthor(string a)
        {
            string connectionString = "datasource=127.0.0.1;port=3306;username=root;password=;database=LMS;";
            string query = "select * from artifacts where author ='" + a + "'";

            MySqlConnection databaseConnection = new MySqlConnection(connectionString);
            MySqlCommand commandDatabase = new MySqlCommand(query, databaseConnection);
            commandDatabase.CommandTimeout = 60;
            MySqlDataReader reader;

            try
            {

                databaseConnection.Open();
                reader = commandDatabase.ExecuteReader();

                if (reader.HasRows)
                {
                    int i = 0, x = 0;

                    while (reader.Read())
                    {
                        string[] row = { reader.GetString(0), reader.GetString(1), reader.GetString(2), reader.GetString(3), 
                                         reader.GetString(4), reader.GetString(5), reader.GetString(6), reader.GetString(7), reader.GetString(8), reader.GetString(9), reader.GetString(10), };
                        listBoxSearch.Items.Add(row[1] + "\t\t" + row[2] + " by " + row[3] + " is " + row[10] + "\t\t" + row[5]);
                        // allRecordsListBox.Items.Add(row[2]);
                        Button btn = new Button();

                        btn.Location = new Point(600, 0 + x);
                        btn.BackColor = System.Drawing.Color.White;
                        btn.Text = "Issue";
                        btn.Height = 18;
                        btn.Font = new Font(btn.Font.FontFamily, 7);
                        btn.Name = reader.GetString(0);

                        //Hook our button up to our generic button handler
                        btn.Click += new EventHandler(btn_Click);
                        listBoxSearch.Controls.Add(btn);
                        i += 10;
                        x += 20;

                    }
                }
                else
                {
                    Console.WriteLine("No rows found.");
                }

                databaseConnection.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }

        }

        private void allRecordsLabel_Click(object sender, EventArgs e)
        {

        }

        //Books Artifact
        private void button1_Click(object sender, EventArgs e)
        {
            allRecordsListBox.Items.Clear();
            string connectionString = "datasource=127.0.0.1;port=3306;username=root;password=;database=LMS;";
            string query = "SELECT * FROM artifacts WHERE artType = 'Book'";

            MySqlConnection databaseConnection = new MySqlConnection(connectionString);
            MySqlCommand commandDatabase = new MySqlCommand(query, databaseConnection);
            commandDatabase.CommandTimeout = 60;
            MySqlDataReader reader;

            try
            {

                databaseConnection.Open();
                reader = commandDatabase.ExecuteReader();

                if (reader.HasRows)
                {
                    while (reader.Read())
                    {
                        string[] row = { reader.GetString(0), reader.GetString(1), reader.GetString(2), reader.GetString(3),
                                         reader.GetString(4), reader.GetString(5), reader.GetString(6), reader.GetString(7), reader.GetString(8), reader.GetString(9), reader.GetString(10), };
                        allRecordsListBox.Items.Add(row[0] + ".  " + row[1] + "      " + row[2] + " by " + row[3] + "     " + row[4] + "      " + row[5] + "     " + row[6] + "      " + row[7] + "      " + row[8] + "       " + row[9] + "       " + row[10]);
                        // allRecordsListBox.Items.Add(row[2]);

                    }
                }
                else
                {
                    Console.WriteLine("No rows found.");
                }

                databaseConnection.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }

        }

        private void journals_Click(object sender, EventArgs e)
        {
            allRecordsListBox.Items.Clear();
            string connectionString = "datasource=127.0.0.1;port=3306;username=root;password=;database=LMS;";
            string query = "SELECT * FROM artifacts WHERE artType = 'Journal'";

            MySqlConnection databaseConnection = new MySqlConnection(connectionString);
            MySqlCommand commandDatabase = new MySqlCommand(query, databaseConnection);
            commandDatabase.CommandTimeout = 60;
            MySqlDataReader reader;

            try{
                databaseConnection.Open();
                reader = commandDatabase.ExecuteReader();
                if (reader.HasRows){
                    while (reader.Read()){
                        string[] row = { reader.GetString(0), reader.GetString(1), reader.GetString(2), reader.GetString(3),
                                         reader.GetString(4), reader.GetString(5), reader.GetString(6), reader.GetString(7), reader.GetString(8), reader.GetString(9), reader.GetString(10), };
                        allRecordsListBox.Items.Add(row[0] + ".  " + row[1] + "      " + row[2] + " by " + row[3] + "     " + row[4] + "      " + row[5] + "     " + row[6] + "      " + row[7] + "      " + row[8] + "       " + row[9] + "       " + row[10]);
                        // allRecordsListBox.Items.Add(row[2]);
                    }
                }
                else
                {
                    Console.WriteLine("No rows found.");
                }

                databaseConnection.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
            }

        }

        //LOG IN Button
        public void button1_Click_1(object sender, EventArgs e)
        {
            login loginwin = new login(this);
            loginwin.Show();

            
        }

        public void registeration_Click(object sender, EventArgs e)
        {
            Register blob = new Register();
            blob.Show();
        }

        public void logout_Click(object sender, EventArgs e)
        {
            uid = 0;
            logout.Hide();
            button1.Show();
            registeration.Show();
            tabAllRecords.TabPages.Remove(login);
        }

        private void allRecordsListBox_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
        private void HideTab1_Click(object sender, EventArgs e)
        {
            
        }

        private void textBoxTitle_TextChanged(object sender, EventArgs e)
        {

        }

        private void listBoxSearch_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void textBoxGenre_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
