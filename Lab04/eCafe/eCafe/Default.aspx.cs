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
        private void Page_Load(object sender, System.EventArgs e)
        {

        }
        protected void btnSubmit_Click(object sender, EventArgs e){
            string gender = "male";
            if (!optionsRadios1.Checked)
                gender = "female";

            string connectString = "datasource=127.0.0.1;port=3306;username=root;password=;database=datarepo; ";
            using (var conn = new MySqlConnection(connectString))
            using (var cmd = conn.CreateCommand())
            {
                conn.Open();
                cmd.CommandText = "INSERT INTO user ( name, username, pass, email, dob, gender) VALUES (@Name, @Username, @password, @email, @dob, @gender); ";
                cmd.Parameters.AddWithValue("@Name", fullname.Value);
                cmd.Parameters.AddWithValue("@Username", username.Value);
                cmd.Parameters.AddWithValue("@password", pass.Value);
                cmd.Parameters.AddWithValue("@email", email.Value);
                cmd.Parameters.AddWithValue("@dob", dob.Value);
                cmd.Parameters.AddWithValue("@gender", gender);

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
    }
}
