using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using MySql.Data.MySqlClient;

namespace eCafe
{
    public partial class _Default : Page
    {
        public TextBox nameTextBox;
        public TextBox priceTextBox;
        public TextBox quantityTextBox;
        public TextBox typeTextBox;

        public TextBox unameTextBox;
        public TextBox uunameTextBox;
        public TextBox upasswordTextBox;
        public TextBox udomainTextBox;

        private void Page_Load(object sender, System.EventArgs e)
        {
            menuTableCreation();
            userTableCreation();
        }

        protected void menuTableCreation()
        {
            string connectString = "datasource=127.0.0.1;port=3306;username=root;password=;database=ecafe; ";

            using (var conn = new MySqlConnection(connectString))
            using (var cmd = conn.CreateCommand())
            {
                conn.Open();
                cmd.CommandText = "SELECT * FROM menu";
                using (var reader = cmd.ExecuteReader())
                {
                    //Set a table width.
                    DisplayTable.Width = Unit.Percentage(90.00);
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
                    TypeHeading.Text = "Type";
                    TypeHeading.HorizontalAlign = HorizontalAlign.Left;
                    tableHeading.Cells.Add(TypeHeading);

                    //Create and add the cells that contain the Phone column heading text.
                    TableHeaderCell PriceHeading = new TableHeaderCell();
                    PriceHeading.Text = "Price";
                    PriceHeading.HorizontalAlign = HorizontalAlign.Left;
                    tableHeading.Cells.Add(PriceHeading);

                    //Create and add the cells that contain the Phone column heading text.
                    TableHeaderCell QuantityHeading = new TableHeaderCell();
                    QuantityHeading.Text = "Quantity";
                    QuantityHeading.HorizontalAlign = HorizontalAlign.Left;
                    tableHeading.Cells.Add(QuantityHeading);

                    DisplayTable.Rows.Add(tableHeading);

                    //Loop through the resultant data selection and add the data value
                    //for each respective column in the table.
                    while (reader.Read())
                    {
                        TableRow detailsRow = new TableRow();
                        TableCell IDCell = new TableCell();
                        IDCell.Text = reader["dish_id"].ToString();
                        detailsRow.Cells.Add(IDCell);

                        TableCell NameCell = new TableCell();
                        NameCell.Text = reader["name"].ToString();
                        detailsRow.Cells.Add(NameCell);

                        TableCell TypeCell = new TableCell();
                        TypeCell.Text = reader["type"].ToString();
                        detailsRow.Cells.Add(TypeCell);

                        TableCell PriceCell = new TableCell();
                        PriceCell.Text = reader["price"].ToString();
                        detailsRow.Cells.Add(PriceCell);

                        TableCell QuantityCell = new TableCell();
                        QuantityCell.Text = reader["quantity"].ToString();
                        detailsRow.Cells.Add(QuantityCell);

                        TableCell tabButton = new TableCell();
                        Button button = new Button();
                        button.Click += new EventHandler(delmenu_button_Click);
                        button.Text = "Delete";
                        button.ID = reader["dish_id"].ToString();
                        //Button.CssClass = "btn btn-default";
                        tabButton.Controls.Add(button);
                        detailsRow.Cells.Add(tabButton);
                        //DisplayTable.Rows[0].Cells[0].Controls.Add(button);

                        DisplayTable.Rows.Add(detailsRow);
                    }

                    TableRow addrow = new TableRow();

                    TableCell auIDCell = new TableCell();
                    addrow.Cells.Add(auIDCell);

                    TableCell auNameCell = new TableCell();
                    nameTextBox = new TextBox();
                    nameTextBox.ID = "auName";
                    auNameCell.Controls.Add(nameTextBox);
                    addrow.Cells.Add(auNameCell);

                    TableCell auTypeCell = new TableCell();
                    typeTextBox = new TextBox();
                    typeTextBox.ID = "auType";
                    auTypeCell.Controls.Add(typeTextBox);
                    addrow.Cells.Add(auTypeCell);

                    TableCell auPriceCell = new TableCell();
                    priceTextBox = new TextBox();
                    priceTextBox.ID = "auPrice";
                    auPriceCell.Controls.Add(priceTextBox);
                    addrow.Cells.Add(auPriceCell);

                    TableCell auQuantityCell = new TableCell();
                    quantityTextBox = new TextBox();
                    quantityTextBox.ID = "auQuantity";
                    auQuantityCell.Controls.Add(quantityTextBox);
                    addrow.Cells.Add(auQuantityCell);

                    TableCell addbut = new TableCell();
                    Button addbutt = new Button();
                    addbutt.Click += new EventHandler(addmenu_button_Click);
                    addbutt.Text = "ADD MENU";
                    addbut.Controls.Add(addbutt);
                    addrow.Cells.Add(addbut);

                    DisplayTable.Rows.Add(addrow);
                }
            }
        }

        protected void userTableCreation()
        {
            string connectString = "datasource=127.0.0.1;port=3306;username=root;password=;database=ecafe; ";

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
                    TableHeaderCell PriceHeading = new TableHeaderCell();
                    PriceHeading.Text = "Domain";
                    PriceHeading.HorizontalAlign = HorizontalAlign.Left;
                    tableHeading.Cells.Add(PriceHeading);

                    //Create and add the cells that contain the Phone column heading text.
                    TableHeaderCell QuantityHeading = new TableHeaderCell();
                    QuantityHeading.Text = "Password";
                    QuantityHeading.HorizontalAlign = HorizontalAlign.Left;
                    tableHeading.Cells.Add(QuantityHeading);

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
                        NameCell.Text = reader["Name"].ToString();
                        detailsRow.Cells.Add(NameCell);

                        TableCell userCell = new TableCell();
                        userCell.Text = reader["Username"].ToString();
                        detailsRow.Cells.Add(userCell);

                        TableCell domainCell = new TableCell();
                        domainCell.Text = reader["domain"].ToString();
                        detailsRow.Cells.Add(domainCell);

                        TableCell QuantityCell = new TableCell();
                        detailsRow.Cells.Add(QuantityCell);

                        TableCell tabButton = new TableCell();
                        Button button = new Button();
                        button.Click += new EventHandler(deluser_button_Click);
                        button.Text = "Delete";
                        button.ID = reader["user_id"].ToString() + "a";
                        //Button.CssClass = "btn btn-default";
                        tabButton.Controls.Add(button);
                        detailsRow.Cells.Add(tabButton);
                        //userTable.Rows[0].Cells[0].Controls.Add(button);

                        userTable.Rows.Add(detailsRow);
                    }

                    TableRow addrow = new TableRow();

                    TableCell auIDCell = new TableCell();
                    addrow.Cells.Add(auIDCell);

                    TableCell auNameCell = new TableCell();
                    unameTextBox = new TextBox();
                    unameTextBox.ID = "Name";
                    auNameCell.Controls.Add(unameTextBox);
                    addrow.Cells.Add(auNameCell);

                    TableCell auTypeCell = new TableCell();
                    uunameTextBox = new TextBox();
                    uunameTextBox.ID = "Username";
                    auTypeCell.Controls.Add(uunameTextBox);
                    addrow.Cells.Add(auTypeCell);

                    TableCell auPriceCell = new TableCell();
                    udomainTextBox = new TextBox();
                    udomainTextBox.ID = "domain";
                    auPriceCell.Controls.Add(udomainTextBox);
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
            string connectString = "datasource=127.0.0.1;port=3306;username=root;password=;database=ecafe; ";

            using (var conn = new MySqlConnection(connectString))
            using (var cmd = conn.CreateCommand())
            {
                if (string.IsNullOrWhiteSpace(unameTextBox.Text)) { return; }
                if (string.IsNullOrWhiteSpace(uunameTextBox.Text)) { return; }
                if (string.IsNullOrWhiteSpace(upasswordTextBox.Text)) { return; }
                if (string.IsNullOrWhiteSpace(udomainTextBox.Text)) { return; }

                conn.Open();
                cmd.CommandText = "INSERT INTO user ( Name, Username, domain, password) VALUES ( @Name, @Username, @domain, @password)";
                cmd.Parameters.AddWithValue("@Name", unameTextBox.Text);
                cmd.Parameters.AddWithValue("@Username", uunameTextBox.Text);
                cmd.Parameters.AddWithValue("@domain", udomainTextBox.Text);
                cmd.Parameters.AddWithValue("@password", upasswordTextBox.Text);

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

        protected void addmenu_button_Click(object sender, EventArgs e)
        {
            Button button = sender as Button;
            string connectString = "datasource=127.0.0.1;port=3306;username=root;password=;database=ecafe; ";

            using (var conn = new MySqlConnection(connectString))
            using (var cmd = conn.CreateCommand())
            {
                if (string.IsNullOrWhiteSpace(nameTextBox.Text)) { return; }
                if (string.IsNullOrWhiteSpace(priceTextBox.Text)) { return; }
                if (string.IsNullOrWhiteSpace(quantityTextBox.Text)) { return; }
                if (string.IsNullOrWhiteSpace(typeTextBox.Text)) { return; }

                conn.Open();
                cmd.CommandText = "INSERT INTO menu ( name, price, quantity, type) VALUES ( @name, @price, @quantity, @type)";
                cmd.Parameters.AddWithValue("@name", nameTextBox.Text);
                cmd.Parameters.AddWithValue("@price", priceTextBox.Text);
                cmd.Parameters.AddWithValue("@quantity", quantityTextBox.Text);
                cmd.Parameters.AddWithValue("@type", typeTextBox.Text);

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

        protected void delmenu_button_Click(object sender, EventArgs e)
        {
            Button button = sender as Button;
            int buttonID = Convert.ToInt32(button.ID);

            string connectString = "datasource=127.0.0.1;port=3306;username=root;password=;database=ecafe; ";
            using (var conn = new MySqlConnection(connectString))
            using (var cmd = conn.CreateCommand())
            {
                conn.Open();
                cmd.CommandText = "  DELETE FROM menu WHERE dish_id = " + buttonID + " ";
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

        protected void deluser_button_Click(object sender, EventArgs e)
        {
            Button button = sender as Button;
            string buttonid = button.ID;
            int UserID = Convert.ToInt32(buttonid[0]);

            string connectString = "datasource=127.0.0.1;port=3306;username=root;password=;database=ecafe; ";
            using (var conn = new MySqlConnection(connectString))
            using (var cmd = conn.CreateCommand())
            {
                conn.Open();
                cmd.CommandText = "  DELETE FROM user WHERE user_id = " + UserID + " ";
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