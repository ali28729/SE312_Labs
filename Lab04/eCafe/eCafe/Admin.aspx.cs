using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using MySql.Data.MySqlClient;


namespace eCafe
{
    public partial class About : Page
    { 
        public TextBox fnameTextBox;
        public TextBox unameTextBox;
        public TextBox upasswordTextBox;
        public TextBox genderTextBox;
        public TextBox emailTextBox;
        public TextBox dobTextBox;

        private void Page_Load(object sender, System.EventArgs e)
        {
            userTableCreation();
        }


        protected void userTableCreation()
        {
            string connectString = "datasource=127.0.0.1;port=3306;username=root;password=;database=datarepo; ";

            using (var conn = new MySqlConnection(connectString))
            using (var cmd = conn.CreateCommand())
            {
                conn.Open();
                cmd.CommandText = "SELECT * FROM user";
                using (var reader = cmd.ExecuteReader())
                {
                    //Set a table width.
                    userTable.Width = Unit.Percentage(90.00);
                    //Create a new row for adding a table heading.
                    TableRow tableHeading = new TableRow();

                    //Create and add the cells that contain the Customer ID column heading text.
                    TableHeaderCell IDHeading = new TableHeaderCell();
                    IDHeading.Text = "ID";
                    IDHeading.HorizontalAlign = HorizontalAlign.Left;
                    tableHeading.Cells.Add(IDHeading);

                    //Create and add the cells that contain the Contact Name column heading text.
                    TableHeaderCell NameHeading = new TableHeaderCell();
                    NameHeading.Text = "Name";
                    NameHeading.HorizontalAlign = HorizontalAlign.Left;
                    tableHeading.Cells.Add(NameHeading);

                    //Create and add the cells that contain the Phone column heading text.
                    TableHeaderCell TypeHeading = new TableHeaderCell();
                    TypeHeading.Text = "Username";
                    TypeHeading.HorizontalAlign = HorizontalAlign.Left;
                    tableHeading.Cells.Add(TypeHeading);

                    //Create and add the cells that contain the Phone column heading text.
                    TableHeaderCell dobheading = new TableHeaderCell();
                    dobheading.Text = "Email";
                    dobheading.HorizontalAlign = HorizontalAlign.Left;
                    tableHeading.Cells.Add(dobheading);

                    TableHeaderCell emailHeading = new TableHeaderCell();
                    emailHeading.Text = "Date of Birth";
                    emailHeading.HorizontalAlign = HorizontalAlign.Left;
                    tableHeading.Cells.Add(emailHeading);

                    TableHeaderCell GenderHeading = new TableHeaderCell();
                    GenderHeading.Text = "Gender";
                    GenderHeading.HorizontalAlign = HorizontalAlign.Left;
                    tableHeading.Cells.Add(GenderHeading);

                    //Create and add the cells that contain the Phone column heading text.
                    TableHeaderCell PassHeading = new TableHeaderCell();
                    PassHeading.Text = "Password";
                    PassHeading.HorizontalAlign = HorizontalAlign.Left;
                    tableHeading.Cells.Add(PassHeading);

                    userTable.Rows.Add(tableHeading);

                    //Loop through the resultant data selection and add the data value
                    //for each respective column in the table.
                    while (reader.Read())
                    {
                        TableRow detailsRow = new TableRow();
                        TableCell IDCell = new TableCell();
                        IDCell.Text = reader["user_id"].ToString();
                        detailsRow.Cells.Add(IDCell);

                        TableCell NameCell = new TableCell();
                        NameCell.Text = reader["name"].ToString();
                        detailsRow.Cells.Add(NameCell);

                        TableCell userCell = new TableCell();
                        userCell.Text = reader["Username"].ToString();
                        detailsRow.Cells.Add(userCell);

                        TableCell domainCell = new TableCell();
                        domainCell.Text = reader["email"].ToString();
                        detailsRow.Cells.Add(domainCell);

                        TableCell dbCell = new TableCell();
                        dbCell.Text = reader["dob"].ToString();
                        detailsRow.Cells.Add(dbCell);

                        TableCell genderCell = new TableCell();
                        genderCell.Text = reader["gender"].ToString();
                        detailsRow.Cells.Add(genderCell);

                        TableCell yo = new TableCell();
                        detailsRow.Cells.Add(yo);

                        TableCell tabButton = new TableCell();
                        Button button = new Button();
                        button.Click += new EventHandler(deluser_button_Click);
                        button.Text = "Delete";
                        button.ID = "a" + reader["user_id"].ToString();
                        tabButton.Controls.Add(button);
                        detailsRow.Cells.Add(tabButton);

                        userTable.Rows.Add(detailsRow);
                    }

                    TableRow addrow = new TableRow();

                    TableCell auIDCell = new TableCell();
                    addrow.Cells.Add(auIDCell);

                    TableCell auNameCell = new TableCell();
                    fnameTextBox = new TextBox();
                    fnameTextBox.ID = "Name";
                    auNameCell.Controls.Add(fnameTextBox);
                    addrow.Cells.Add(auNameCell);

                    TableCell unCell = new TableCell();
                    unameTextBox = new TextBox();
                    unameTextBox.ID = "Username";
                    unCell.Controls.Add(unameTextBox);
                    addrow.Cells.Add(unCell);

                    TableCell eCell = new TableCell();
                    emailTextBox = new TextBox();
                    emailTextBox.ID = "email";
                    eCell.Controls.Add(emailTextBox);
                    addrow.Cells.Add(eCell);

                    TableCell dobCell = new TableCell();
                    dobTextBox = new TextBox();
                    dobTextBox.ID = "dob";
                    dobCell.Controls.Add(dobTextBox);
                    addrow.Cells.Add(dobCell);

                    TableCell auPriceCell = new TableCell();
                    genderTextBox = new TextBox();
                    genderTextBox.ID = "gender";
                    auPriceCell.Controls.Add(genderTextBox);
                    addrow.Cells.Add(auPriceCell);

                    TableCell auQuantityCell = new TableCell();
                    upasswordTextBox = new TextBox();
                    upasswordTextBox.Attributes["type"] = "password";
                    upasswordTextBox.ID = "password";
                    auQuantityCell.Controls.Add(upasswordTextBox);
                    addrow.Cells.Add(auQuantityCell);

                    TableCell addbut = new TableCell();
                    Button addbutt = new Button();
                    addbutt.Click += new EventHandler(adduser_button_Click);
                    addbutt.Text = "ADD USER";
                    addbut.Controls.Add(addbutt);
                    addrow.Cells.Add(addbut);

                    userTable.Rows.Add(addrow);
                }
            }
        }

        protected void adduser_button_Click(object sender, EventArgs e)
        {
            Button button = sender as Button;
            string connectString = "datasource=127.0.0.1;port=3306;username=root;password=;database=datarepo; ";

            using (var conn = new MySqlConnection(connectString))
            using (var cmd = conn.CreateCommand())
            {
                if (string.IsNullOrWhiteSpace(fnameTextBox.Text)) { return; }
                if (string.IsNullOrWhiteSpace(unameTextBox.Text)) { return; }
                if (string.IsNullOrWhiteSpace(upasswordTextBox.Text)) { return; }
                if (string.IsNullOrWhiteSpace(genderTextBox.Text)) { return; }
                if (string.IsNullOrWhiteSpace(dobTextBox.Text)) { return; }
                if (string.IsNullOrWhiteSpace(emailTextBox.Text)) { return; }

                conn.Open();
                cmd.CommandText = "INSERT INTO user ( name, username, pass, email, dob, gender) VALUES (@Name, @Username, @password, @email, @dob, @gender); ";
                cmd.Parameters.AddWithValue("@Name", fnameTextBox.Text);
                cmd.Parameters.AddWithValue("@Username", unameTextBox.Text);
                cmd.Parameters.AddWithValue("@password", upasswordTextBox.Text);
                cmd.Parameters.AddWithValue("@email", emailTextBox.Text);
                cmd.Parameters.AddWithValue("@dob", dobTextBox.Text);
                cmd.Parameters.AddWithValue("@gender", genderTextBox.Text);

                int reader = cmd.ExecuteNonQuery();
                if (reader >= 0)
                {
                    Console.WriteLine("Inserted Succesfully!");
                    Page.Response.Redirect(Page.Request.Url.ToString(), true);
                }
                else
                {
                    Console.WriteLine("Error inserting data into Database!");
                }
            }
        }

        protected void deluser_button_Click(object sender, EventArgs e)
        {
            Button button = sender as Button;
            string buttonid = button.ID.Substring(1, button.ID.Length - 1);
            string connectString = "datasource=127.0.0.1;port=3306;username=root;password=;database=datarepo; ";
            using (var conn = new MySqlConnection(connectString))
            using (var cmd = conn.CreateCommand())
            {
                conn.Open();
                cmd.CommandText = "  DELETE FROM user WHERE user_id = " + Convert.ToInt32(buttonid);
                int reader = cmd.ExecuteNonQuery();
                if (reader >= 0)
                {
                    Page.Response.Redirect(Page.Request.Url.ToString(), true);
                }
                else
                {
                    Console.WriteLine("Error deleting data from Database!");
                }
            }
        }
    }
}