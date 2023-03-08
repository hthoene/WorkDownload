package work.download.email;

import org.springframework.stereotype.Service;

@Service
public class EmailTemplateGenerator {


    private static String confirmEmail = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" style=\"font-family:arial, 'helvetica neue', helvetica, sans-serif\">\n" +
            " <head>\n" +
            "  <meta charset=\"UTF-8\">\n" +
            "  <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" +
            "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
            "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "  <meta content=\"telephone=no\" name=\"format-detection\">\n" +
            "  <title>New message</title><!--[if (mso 16)]>\n" +
            "    <style type=\"text/css\">\n" +
            "    a {text-decoration: none;}\n" +
            "    </style>\n" +
            "    <![endif]--><!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]--><!--[if gte mso 9]>\n" +
            "<xml>\n" +
            "    <o:OfficeDocumentSettings>\n" +
            "    <o:AllowPNG></o:AllowPNG>\n" +
            "    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
            "    </o:OfficeDocumentSettings>\n" +
            "</xml>\n" +
            "<![endif]--><!--[if !mso]><!-- -->\n" +
            "  <link href=\"https://fonts.googleapis.com/css?family=Roboto:400,400i,700,700i\" rel=\"stylesheet\"><!--<![endif]-->\n" +
            "  <style type=\"text/css\">\n" +
            "#outlook a {\n" +
            "\tpadding:0;\n" +
            "}\n" +
            ".es-button {\n" +
            "\tmso-style-priority:100!important;\n" +
            "\ttext-decoration:none!important;\n" +
            "}\n" +
            "a[x-apple-data-detectors] {\n" +
            "\tcolor:inherit!important;\n" +
            "\ttext-decoration:none!important;\n" +
            "\tfont-size:inherit!important;\n" +
            "\tfont-family:inherit!important;\n" +
            "\tfont-weight:inherit!important;\n" +
            "\tline-height:inherit!important;\n" +
            "}\n" +
            ".es-desk-hidden {\n" +
            "\tdisplay:none;\n" +
            "\tfloat:left;\n" +
            "\toverflow:hidden;\n" +
            "\twidth:0;\n" +
            "\tmax-height:0;\n" +
            "\tline-height:0;\n" +
            "\tmso-hide:all;\n" +
            "}\n" +
            "[data-ogsb] .es-button {\n" +
            "\tborder-width:0!important;\n" +
            "\tpadding:10px 20px 10px 20px!important;\n" +
            "}\n" +
            ".es-button-border:hover a.es-button, .es-button-border:hover button.es-button {\n" +
            "\tbackground:#56d66b!important;\n" +
            "\tborder-color:#56d66b!important;\n" +
            "}\n" +
            ".es-button-border:hover {\n" +
            "\tborder-color:#42d159 #42d159 #42d159 #42d159!important;\n" +
            "\tbackground:#56d66b!important;\n" +
            "}\n" +
            "td .es-button-border:hover a.es-button-1 {\n" +
            "\tbackground:#316bc9!important;\n" +
            "\tborder-color:#316bc9!important;\n" +
            "}\n" +
            "td .es-button-border-2:hover {\n" +
            "\tbackground:#316bc9!important;\n" +
            "\tborder-style:solid solid solid solid!important;\n" +
            "\tborder-color:#42d159 #42d159 #42d159 #42d159!important;\n" +
            "}\n" +
            "[data-ogsb] .es-button.es-button-3 {\n" +
            "\tpadding:10px 30px!important;\n" +
            "}\n" +
            "@media only screen and (max-width:600px) {p, ul li, ol li, a { line-height:150%!important } h1, h2, h3, h1 a, h2 a, h3 a { line-height:120% } h1 { font-size:30px!important; text-align:left } h2 { font-size:24px!important; text-align:left } h3 { font-size:20px!important; text-align:left } .es-header-body h1 a, .es-content-body h1 a, .es-footer-body h1 a { font-size:30px!important; text-align:left } .es-header-body h2 a, .es-content-body h2 a, .es-footer-body h2 a { font-size:24px!important; text-align:left } .es-header-body h3 a, .es-content-body h3 a, .es-footer-body h3 a { font-size:20px!important; text-align:left } .es-menu td a { font-size:14px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:14px!important } .es-content-body p, .es-content-body ul li, .es-content-body ol li, .es-content-body a { font-size:14px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:9px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:10px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:inline-block!important } a.es-button, button.es-button { font-size:18px!important; display:inline-block!important } .es-adaptive table, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0px!important } .es-m-p0r { padding-right:0px!important } .es-m-p0l { padding-left:0px!important } .es-m-p0t { padding-top:0px!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } tr.es-desk-hidden, td.es-desk-hidden, table.es-desk-hidden { width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } tr.es-desk-hidden { display:table-row!important } table.es-desk-hidden { display:table!important } td.es-desk-menu-hidden { display:table-cell!important } .es-menu td { width:1%!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } .es-desk-hidden { display:table-row!important; width:auto!important; overflow:visible!important; max-height:inherit!important } }\n" +
            "</style>\n" +
            " </head>\n" +
            " <body style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\n" +
            "  <div class=\"es-wrapper-color\" style=\"background-color:#F6F6F6\"><!--[if gte mso 9]>\n" +
            "\t\t\t<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
            "\t\t\t\t<v:fill type=\"tile\" color=\"#f6f6f6\"></v:fill>\n" +
            "\t\t\t</v:background>\n" +
            "\t\t<![endif]-->\n" +
            "   <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;background-color:#F6F6F6\">\n" +
            "     <tr>\n" +
            "      <td valign=\"top\" style=\"padding:0;Margin:0\">\n" +
            "       <table class=\"es-header\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" +
            "         <tr>\n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
            "           <table class=\"es-header-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
            "             <tr>\n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0\">\n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                 <tr>\n" +
            "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:600px\">\n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><img class=\"adapt-img\" src=\"https://yzpmim.stripocdn.email/content/guids/CABINET_0a46257e01ebf89d31257bf49c8f7bfbc780f78301946f7959c8a43135f1b8f4/images/emailheaderwd.jpg\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"600\"></td>\n" +
            "                     </tr>\n" +
            "                   </table></td>\n" +
            "                 </tr>\n" +
            "               </table></td>\n" +
            "             </tr>\n" +
            "           </table></td>\n" +
            "         </tr>\n" +
            "       </table>\n" +
            "       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
            "         <tr>\n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
            "           <table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
            "             <tr>\n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;padding-left:20px;padding-right:20px;padding-top:40px\">\n" +
            "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                 <tr>\n" +
            "                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">\n" +
            "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:21px;color:#333333;font-size:14px\">Hello <strong>[NAME]&nbsp;\uD83D\uDC4B</strong></p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:21px;color:#333333;font-size:14px\">Please confirm your email</p></td>\n" +
            "                     </tr>\n" +
            "                   </table></td>\n" +
            "                 </tr>\n" +
            "               </table></td>\n" +
            "             </tr>\n" +
            "             <tr>\n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\">\n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                 <tr>\n" +
            "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0\"><!--[if mso]><a href=\"[CONFIRM_LINK]\" target=\"_blank\" hidden>\n" +
            "\t<v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" esdevVmlButton href=\"[CONFIRM_LINK]\" \n" +
            "                style=\"height:41px; v-text-anchor:middle; width:173px\" arcsize=\"10%\" stroke=\"f\"  fillcolor=\"#3670de\">\n" +
            "\t\t<w:anchorlock></w:anchorlock>\n" +
            "\t\t<center style='color:#ffffff; font-family:roboto, \"helvetica neue\", helvetica, arial, sans-serif; font-size:15px; font-weight:400; line-height:15px;  mso-text-raise:1px'>Confirm Email</center>\n" +
            "\t</v:roundrect></a>\n" +
            "<![endif]--><!--[if !mso]><!-- --><span class=\"msohide es-button-border-2 es-button-border\" style=\"border-style:solid;border-color:#2cb543;background:#3670de;border-width:0px;display:inline-block;border-radius:4px;width:auto;mso-hide:all\"><a href=\"[CONFIRM_LINK]\" class=\"es-button es-button-1\" target=\"_blank\" style=\"mso-style-priority:100 !important;text-decoration:none;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;color:#FFFFFF;font-size:18px;border-style:solid;border-color:#3670de;border-width:10px 30px;display:inline-block;background:#3670de;border-radius:4px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;font-weight:normal;font-style:normal;line-height:22px;width:auto;text-align:center\">Confirm Email</a></span><!--<![endif]--></td>\n" +
            "                     </tr>\n" +
            "                   </table></td>\n" +
            "                 </tr>\n" +
            "               </table></td>\n" +
            "             </tr>\n" +
            "           </table></td>\n" +
            "         </tr>\n" +
            "       </table>\n" +
            "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
            "         <tr>\n" +
            "          <td class=\"es-info-area\" align=\"center\" style=\"padding:0;Margin:0\">\n" +
            "           <table bgcolor=\"#ffffff\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
            "             <tr>\n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\">\n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                 <tr>\n" +
            "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" class=\"es-infoblock\" style=\"padding:0;Margin:0;line-height:14px;font-size:12px;color:#CCCCCC\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:13px;color:#a9a9a9;font-size:11px\">If you did not sign up on <a target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#3670de;font-size:11px\" href=\"https://work.download/\">work.download</a>, you can ignore this email</p></td>\n" +
            "                     </tr>\n" +
            "                   </table></td>\n" +
            "                 </tr>\n" +
            "               </table></td>\n" +
            "             </tr>\n" +
            "           </table></td>\n" +
            "         </tr>\n" +
            "       </table>\n" +
            "       <table class=\"es-footer\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" +
            "         <tr>\n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
            "           <table class=\"es-footer-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
            "             <tr>\n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\">\n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                 <tr>\n" +
            "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:40px;font-size:0\">\n" +
            "                       <table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                         <tr>\n" +
            "                          <td style=\"padding:0;Margin:0;border-bottom:1px solid #cccccc;background:unset;height:1px;width:100%;margin:0px\"></td>\n" +
            "                         </tr>\n" +
            "                       </table></td>\n" +
            "                     </tr>\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:30px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:14px;color:#d3d3d3;font-size:9px\">contact@work.download<br>Hannes Thöne<br>Nordstraße 16, 34414 Warburg,<br>Germany, Nordrhein-Westfalen<br><a target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#3670de;font-size:9px;white-space:nowrap;word-break:break-all\" href=\"[UNSUBSCRIBE_LINK]\">unsubscribe</a></p></td>\n" +
            "                     </tr>\n" +
            "                   </table></td>\n" +
            "                 </tr>\n" +
            "               </table></td>\n" +
            "             </tr>\n" +
            "           </table></td>\n" +
            "         </tr>\n" +
            "       </table></td>\n" +
            "     </tr>\n" +
            "   </table>\n" +
            "  </div>\n" +
            " </body>\n" +
            "</html>";

    private static String deliveredEmail = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" style=\"font-family:arial, 'helvetica neue', helvetica, sans-serif\">\n" +
            " <head>\n" +
            "  <meta charset=\"UTF-8\">\n" +
            "  <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" +
            "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
            "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "  <meta content=\"telephone=no\" name=\"format-detection\">\n" +
            "  <title>Delivered</title><!--[if (mso 16)]>\n" +
            "    <style type=\"text/css\">\n" +
            "    a {text-decoration: none;}\n" +
            "    </style>\n" +
            "    <![endif]--><!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]--><!--[if gte mso 9]>\n" +
            "<xml>\n" +
            "    <o:OfficeDocumentSettings>\n" +
            "    <o:AllowPNG></o:AllowPNG>\n" +
            "    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
            "    </o:OfficeDocumentSettings>\n" +
            "</xml>\n" +
            "<![endif]--><!--[if !mso]><!-- -->\n" +
            "  <link href=\"https://fonts.googleapis.com/css?family=Roboto:400,400i,700,700i\" rel=\"stylesheet\"><!--<![endif]-->\n" +
            "  <style type=\"text/css\">\n" +
            "#outlook a {\n" +
            "\tpadding:0;\n" +
            "}\n" +
            ".es-button {\n" +
            "\tmso-style-priority:100!important;\n" +
            "\ttext-decoration:none!important;\n" +
            "}\n" +
            "a[x-apple-data-detectors] {\n" +
            "\tcolor:inherit!important;\n" +
            "\ttext-decoration:none!important;\n" +
            "\tfont-size:inherit!important;\n" +
            "\tfont-family:inherit!important;\n" +
            "\tfont-weight:inherit!important;\n" +
            "\tline-height:inherit!important;\n" +
            "}\n" +
            ".es-desk-hidden {\n" +
            "\tdisplay:none;\n" +
            "\tfloat:left;\n" +
            "\toverflow:hidden;\n" +
            "\twidth:0;\n" +
            "\tmax-height:0;\n" +
            "\tline-height:0;\n" +
            "\tmso-hide:all;\n" +
            "}\n" +
            "[data-ogsb] .es-button {\n" +
            "\tborder-width:0!important;\n" +
            "\tpadding:10px 20px 10px 20px!important;\n" +
            "}\n" +
            ".es-button-border:hover a.es-button,\n" +
            ".es-button-border:hover button.es-button {\n" +
            "\tbackground:#56d66b!important;\n" +
            "\tborder-color:#56d66b!important;\n" +
            "}\n" +
            ".es-button-border:hover {\n" +
            "\tborder-color:#42d159 #42d159 #42d159 #42d159!important;\n" +
            "\tbackground:#56d66b!important;\n" +
            "}\n" +
            "td .es-button-border:hover a.es-button-1 {\n" +
            "\tbackground:#316bc9!important;\n" +
            "\tborder-color:#316bc9!important;\n" +
            "}\n" +
            "td .es-button-border-2:hover {\n" +
            "\tbackground:#316bc9!important;\n" +
            "\tborder-style:solid solid solid solid!important;\n" +
            "\tborder-color:#42d159 #42d159 #42d159 #42d159!important;\n" +
            "}\n" +
            "[data-ogsb] .es-button.es-button-3 {\n" +
            "\tpadding:10px 30px!important;\n" +
            "}\n" +
            "@media only screen and (max-width:600px) {p, ul li, ol li, a { line-height:150%!important } h1, h2, h3, h1 a, h2 a, h3 a { line-height:120% } h1 { font-size:30px!important; text-align:left } h2 { font-size:24px!important; text-align:left } h3 { font-size:20px!important; text-align:left } .es-header-body h1 a, .es-content-body h1 a, .es-footer-body h1 a { font-size:30px!important; text-align:left } .es-header-body h2 a, .es-content-body h2 a, .es-footer-body h2 a { font-size:24px!important; text-align:left } .es-header-body h3 a, .es-content-body h3 a, .es-footer-body h3 a { font-size:20px!important; text-align:left } .es-menu td a { font-size:14px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:14px!important } .es-content-body p, .es-content-body ul li, .es-content-body ol li, .es-content-body a { font-size:14px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:9px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:10px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:inline-block!important } a.es-button, button.es-button { font-size:18px!important; display:inline-block!important } .es-adaptive table, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0!important } .es-m-p0r { padding-right:0!important } .es-m-p0l { padding-left:0!important } .es-m-p0t { padding-top:0!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } tr.es-desk-hidden, td.es-desk-hidden, table.es-desk-hidden { width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } tr.es-desk-hidden { display:table-row!important } table.es-desk-hidden { display:table!important } td.es-desk-menu-hidden { display:table-cell!important } .es-menu td { width:1%!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } .es-desk-hidden { display:table-row!important; width:auto!important; overflow:visible!important; max-height:inherit!important } .es-m-p5 { padding:5px!important } .es-m-p5t { padding-top:5px!important } .es-m-p5b { padding-bottom:5px!important } .es-m-p5r { padding-right:5px!important } .es-m-p5l { padding-left:5px!important } .es-m-p10 { padding:10px!important } .es-m-p10t { padding-top:10px!important } .es-m-p10b { padding-bottom:10px!important } .es-m-p10r { padding-right:10px!important } .es-m-p10l { padding-left:10px!important } .es-m-p15 { padding:15px!important } .es-m-p15t { padding-top:15px!important } .es-m-p15b { padding-bottom:15px!important } .es-m-p15r { padding-right:15px!important } .es-m-p15l { padding-left:15px!important } .es-m-p20 { padding:20px!important } .es-m-p20t { padding-top:20px!important } .es-m-p20r { padding-right:20px!important } .es-m-p20l { padding-left:20px!important } .es-m-p25 { padding:25px!important } .es-m-p25t { padding-top:25px!important } .es-m-p25b { padding-bottom:25px!important } .es-m-p25r { padding-right:25px!important } .es-m-p25l { padding-left:25px!important } .es-m-p30 { padding:30px!important } .es-m-p30t { padding-top:30px!important } .es-m-p30b { padding-bottom:30px!important } .es-m-p30r { padding-right:30px!important } .es-m-p30l { padding-left:30px!important } .es-m-p35 { padding:35px!important } .es-m-p35t { padding-top:35px!important } .es-m-p35b { padding-bottom:35px!important } .es-m-p35r { padding-right:35px!important } .es-m-p35l { padding-left:35px!important } .es-m-p40 { padding:40px!important } .es-m-p40t { padding-top:40px!important } .es-m-p40b { padding-bottom:40px!important } .es-m-p40r { padding-right:40px!important } .es-m-p40l { padding-left:40px!important } }\n" +
            "@media screen and (max-width:800px) {.styled-table th, .styled-table td { font-size:0.6rem } }\n" +
            "</style>\n" +
            " </head>\n" +
            " <body style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\n" +
            "  <div class=\"es-wrapper-color\" style=\"background-color:#F6F6F6\"><!--[if gte mso 9]>\n" +
            "\t\t\t<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
            "\t\t\t\t<v:fill type=\"tile\" color=\"#f6f6f6\"></v:fill>\n" +
            "\t\t\t</v:background>\n" +
            "\t\t<![endif]-->\n" +
            "   <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;background-color:#F6F6F6\">\n" +
            "     <tr>\n" +
            "      <td valign=\"top\" style=\"padding:0;Margin:0\">\n" +
            "       <table class=\"es-header\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" +
            "         <tr>\n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
            "           <table class=\"es-header-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
            "             <tr>\n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0\">\n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                 <tr>\n" +
            "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:600px\">\n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><img class=\"adapt-img\" src=\"https://yzpmim.stripocdn.email/content/guids/CABINET_3367ae247bb176c0388d4009cb25c587f1a93be1fc4190d2af520f57d64515e9/images/emailheaderwd.jpg\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"600\"></td>\n" +
            "                     </tr>\n" +
            "                   </table></td>\n" +
            "                 </tr>\n" +
            "               </table></td>\n" +
            "             </tr>\n" +
            "           </table></td>\n" +
            "         </tr>\n" +
            "       </table>\n" +
            "       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
            "         <tr>\n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
            "           <table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
            "             <tr>\n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;padding-left:20px;padding-right:20px;padding-top:40px\">\n" +
            "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                 <tr>\n" +
            "                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">\n" +
            "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>[DELIVERER] </strong>just delivered your files \uD83C\uDF89</p></td>\n" +
            "                     </tr>\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" class=\"es-m-p20\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:21px;color:#333333;font-size:14px\"><br></p>\n" +
            "                       <table border=\"1\" align=\"center\" cellspacing=\"1\" cellpadding=\"1\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;border-style:none;margin:1rem 0;font-size:0.9rem;font-family:sans-serif;box-shadow:0 0 20px #D8D8D8;width:500px\" class=\"es-table styled-table\" role=\"presentation\">\n" +
            "                        <thead>\n" +
            "                         <tr style=\"background-color:#1672E6;color:#FFFFFF;text-align:center\">\n" +
            "                          <th scope=\"col\" style=\"border-style:none;padding:0.6rem 1rem 0.6rem 1rem;font-size:0.8rem\">Delivered on</th>\n" +
            "                          <th scope=\"col\" style=\"border-style:none;padding:0.6rem 1rem 0.6rem 1rem;font-size:0.8rem\">Password</th>\n" +
            "                         </tr>\n" +
            "                        </thead>\n" +
            "                         <tr style=\"border-bottom:1px solid #DDDDDD\">\n" +
            "                          <td style=\"padding:0.6rem 1rem 0.6rem 1rem;Margin:0;border-style:none;font-size:0.8rem;text-align:center\">[DELIVERED_ON]</td>\n" +
            "                          <td style=\"padding:0.6rem 1rem 0.6rem 1rem;Margin:0;border-style:none;font-size:0.8rem;text-align:center\">[PASSWORD]</td>\n" +
            "                         </tr>\n" +
            "                       </table></td>\n" +
            "                     </tr>\n" +
            "                   </table></td>\n" +
            "                 </tr>\n" +
            "               </table></td>\n" +
            "             </tr>\n" +
            "             <tr>\n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\">\n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                 <tr>\n" +
            "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0\"><!--[if mso]><a href=\"[DOWNLOAD_LINK]\" target=\"_blank\" hidden>\n" +
            "\t<v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" esdevVmlButton href=\"[DOWNLOAD_LINK]\" \n" +
            "                style=\"height:41px; v-text-anchor:middle; width:183px\" arcsize=\"10%\" stroke=\"f\"  fillcolor=\"#3670de\">\n" +
            "\t\t<w:anchorlock></w:anchorlock>\n" +
            "\t\t<center style='color:#ffffff; font-family:roboto, \"helvetica neue\", helvetica, arial, sans-serif; font-size:15px; font-weight:400; line-height:15px;  mso-text-raise:1px'>Download Files</center>\n" +
            "\t</v:roundrect></a>\n" +
            "<![endif]--><!--[if !mso]><!-- --><span class=\"msohide es-button-border-2 es-button-border\" style=\"border-style:solid;border-color:#2cb543;background:#3670de;border-width:0px;display:inline-block;border-radius:4px;width:auto;mso-hide:all\"><a href=\"[DOWNLOAD_LINK]\" class=\"es-button es-button-1\" target=\"_blank\" style=\"mso-style-priority:100 !important;text-decoration:none;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;color:#FFFFFF;font-size:18px;border-style:solid;border-color:#3670de;border-width:10px 30px;display:inline-block;background:#3670de;border-radius:4px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;font-weight:normal;font-style:normal;line-height:22px;width:auto;text-align:center\">Download Files</a></span><!--<![endif]--></td>\n" +
            "                     </tr>\n" +
            "                   </table></td>\n" +
            "                 </tr>\n" +
            "               </table></td>\n" +
            "             </tr>\n" +
            "           </table></td>\n" +
            "         </tr>\n" +
            "       </table>\n" +
            "       <table class=\"es-footer\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" +
            "         <tr>\n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
            "           <table class=\"es-footer-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
            "             <tr>\n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\">\n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                 <tr>\n" +
            "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:40px;font-size:0\">\n" +
            "                       <table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                         <tr>\n" +
            "                          <td style=\"padding:0;Margin:0;border-bottom:1px solid #cccccc;background:unset;height:1px;width:100%;margin:0px\"></td>\n" +
            "                         </tr>\n" +
            "                       </table></td>\n" +
            "                     </tr>\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:30px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:14px;color:#d3d3d3;font-size:9px\">contact@work.download<br>Hannes Thöne<br>Nordstraße 16, 34414 Warburg,<br>Germany, Nordrhein-Westfalen<br><a target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#3670de;font-size:9px;white-space:nowrap;word-break:break-all\" href=\"[UNSUBSCRIBE_LINK]\">unsubscribe</a></p></td>\n" +
            "                     </tr>\n" +
            "                   </table></td>\n" +
            "                 </tr>\n" +
            "               </table></td>\n" +
            "             </tr>\n" +
            "           </table></td>\n" +
            "         </tr>\n" +
            "       </table></td>\n" +
            "     </tr>\n" +
            "   </table>\n" +
            "  </div>\n" +
            " </body>\n" +
            "</html>";

    private static String deliveryCreatedEmail = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" style=\"font-family:arial, 'helvetica neue', helvetica, sans-serif\">\n" +
            " <head>\n" +
            "  <meta charset=\"UTF-8\">\n" +
            "  <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" +
            "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
            "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "  <meta content=\"telephone=no\" name=\"format-detection\">\n" +
            "  <title>DeliveryCreated</title><!--[if (mso 16)]>\n" +
            "    <style type=\"text/css\">\n" +
            "    a {text-decoration: none;}\n" +
            "    </style>\n" +
            "    <![endif]--><!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]--><!--[if gte mso 9]>\n" +
            "<xml>\n" +
            "    <o:OfficeDocumentSettings>\n" +
            "    <o:AllowPNG></o:AllowPNG>\n" +
            "    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
            "    </o:OfficeDocumentSettings>\n" +
            "</xml>\n" +
            "<![endif]--><!--[if !mso]><!-- -->\n" +
            "  <link href=\"https://fonts.googleapis.com/css?family=Roboto:400,400i,700,700i\" rel=\"stylesheet\"><!--<![endif]-->\n" +
            "  <style type=\"text/css\">\n" +
            "#outlook a {\n" +
            "\tpadding:0;\n" +
            "}\n" +
            ".es-button {\n" +
            "\tmso-style-priority:100!important;\n" +
            "\ttext-decoration:none!important;\n" +
            "}\n" +
            "a[x-apple-data-detectors] {\n" +
            "\tcolor:inherit!important;\n" +
            "\ttext-decoration:none!important;\n" +
            "\tfont-size:inherit!important;\n" +
            "\tfont-family:inherit!important;\n" +
            "\tfont-weight:inherit!important;\n" +
            "\tline-height:inherit!important;\n" +
            "}\n" +
            ".es-desk-hidden {\n" +
            "\tdisplay:none;\n" +
            "\tfloat:left;\n" +
            "\toverflow:hidden;\n" +
            "\twidth:0;\n" +
            "\tmax-height:0;\n" +
            "\tline-height:0;\n" +
            "\tmso-hide:all;\n" +
            "}\n" +
            "[data-ogsb] .es-button {\n" +
            "\tborder-width:0!important;\n" +
            "\tpadding:10px 20px 10px 20px!important;\n" +
            "}\n" +
            ".es-button-border:hover a.es-button,\n" +
            ".es-button-border:hover button.es-button {\n" +
            "\tbackground:#56d66b!important;\n" +
            "\tborder-color:#56d66b!important;\n" +
            "}\n" +
            ".es-button-border:hover {\n" +
            "\tborder-color:#42d159 #42d159 #42d159 #42d159!important;\n" +
            "\tbackground:#56d66b!important;\n" +
            "}\n" +
            "td .es-button-border:hover a.es-button-1 {\n" +
            "\tbackground:#316bc9!important;\n" +
            "\tborder-color:#316bc9!important;\n" +
            "}\n" +
            "td .es-button-border-2:hover {\n" +
            "\tbackground:#316bc9!important;\n" +
            "\tborder-style:solid solid solid solid!important;\n" +
            "\tborder-color:#42d159 #42d159 #42d159 #42d159!important;\n" +
            "}\n" +
            "[data-ogsb] .es-button.es-button-3 {\n" +
            "\tpadding:10px 30px!important;\n" +
            "}\n" +
            "@media only screen and (max-width:600px) {p, ul li, ol li, a { line-height:150%!important } h1, h2, h3, h1 a, h2 a, h3 a { line-height:120% } h1 { font-size:30px!important; text-align:left } h2 { font-size:24px!important; text-align:left } h3 { font-size:20px!important; text-align:left } .es-header-body h1 a, .es-content-body h1 a, .es-footer-body h1 a { font-size:30px!important; text-align:left } .es-header-body h2 a, .es-content-body h2 a, .es-footer-body h2 a { font-size:24px!important; text-align:left } .es-header-body h3 a, .es-content-body h3 a, .es-footer-body h3 a { font-size:20px!important; text-align:left } .es-menu td a { font-size:14px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:14px!important } .es-content-body p, .es-content-body ul li, .es-content-body ol li, .es-content-body a { font-size:14px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:9px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:10px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:inline-block!important } a.es-button, button.es-button { font-size:18px!important; display:inline-block!important } .es-adaptive table, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0!important } .es-m-p0r { padding-right:0!important } .es-m-p0l { padding-left:0!important } .es-m-p0t { padding-top:0!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } tr.es-desk-hidden, td.es-desk-hidden, table.es-desk-hidden { width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } tr.es-desk-hidden { display:table-row!important } table.es-desk-hidden { display:table!important } td.es-desk-menu-hidden { display:table-cell!important } .es-menu td { width:1%!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } .es-desk-hidden { display:table-row!important; width:auto!important; overflow:visible!important; max-height:inherit!important } .es-m-p5 { padding:5px!important } .es-m-p5t { padding-top:5px!important } .es-m-p5b { padding-bottom:5px!important } .es-m-p5r { padding-right:5px!important } .es-m-p5l { padding-left:5px!important } .es-m-p10 { padding:10px!important } .es-m-p10t { padding-top:10px!important } .es-m-p10b { padding-bottom:10px!important } .es-m-p10r { padding-right:10px!important } .es-m-p10l { padding-left:10px!important } .es-m-p15 { padding:15px!important } .es-m-p15t { padding-top:15px!important } .es-m-p15b { padding-bottom:15px!important } .es-m-p15r { padding-right:15px!important } .es-m-p15l { padding-left:15px!important } .es-m-p20 { padding:20px!important } .es-m-p20t { padding-top:20px!important } .es-m-p20r { padding-right:20px!important } .es-m-p20l { padding-left:20px!important } .es-m-p25 { padding:25px!important } .es-m-p25t { padding-top:25px!important } .es-m-p25b { padding-bottom:25px!important } .es-m-p25r { padding-right:25px!important } .es-m-p25l { padding-left:25px!important } .es-m-p30 { padding:30px!important } .es-m-p30t { padding-top:30px!important } .es-m-p30b { padding-bottom:30px!important } .es-m-p30r { padding-right:30px!important } .es-m-p30l { padding-left:30px!important } .es-m-p35 { padding:35px!important } .es-m-p35t { padding-top:35px!important } .es-m-p35b { padding-bottom:35px!important } .es-m-p35r { padding-right:35px!important } .es-m-p35l { padding-left:35px!important } .es-m-p40 { padding:40px!important } .es-m-p40t { padding-top:40px!important } .es-m-p40b { padding-bottom:40px!important } .es-m-p40r { padding-right:40px!important } .es-m-p40l { padding-left:40px!important } }\n" +
            "@media screen and (max-width:800px) {.styled-table th, .styled-table td { font-size:0.6rem } }\n" +
            "</style>\n" +
            " </head>\n" +
            " <body style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\n" +
            "  <div class=\"es-wrapper-color\" style=\"background-color:#F6F6F6\"><!--[if gte mso 9]>\n" +
            "\t\t\t<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
            "\t\t\t\t<v:fill type=\"tile\" color=\"#f6f6f6\"></v:fill>\n" +
            "\t\t\t</v:background>\n" +
            "\t\t<![endif]-->\n" +
            "   <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;background-color:#F6F6F6\">\n" +
            "     <tr>\n" +
            "      <td valign=\"top\" style=\"padding:0;Margin:0\">\n" +
            "       <table class=\"es-header\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" +
            "         <tr>\n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
            "           <table class=\"es-header-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
            "             <tr>\n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0\">\n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                 <tr>\n" +
            "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:600px\">\n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><img class=\"adapt-img\" src=\"https://yzpmim.stripocdn.email/content/guids/CABINET_a49272702576f3d65964918bab416e4ea8d47245e023537da2d59951a5d9269d/images/emailheaderwd.jpg\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"600\"></td>\n" +
            "                     </tr>\n" +
            "                   </table></td>\n" +
            "                 </tr>\n" +
            "               </table></td>\n" +
            "             </tr>\n" +
            "           </table></td>\n" +
            "         </tr>\n" +
            "       </table>\n" +
            "       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
            "         <tr>\n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
            "           <table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
            "             <tr>\n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;padding-left:20px;padding-right:20px;padding-top:40px\">\n" +
            "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                 <tr>\n" +
            "                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">\n" +
            "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>[DELIVERER] </strong>created a new Delivery for you&nbsp;\uD83C\uDF89</p></td>\n" +
            "                     </tr>\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" class=\"es-m-p20\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:21px;color:#333333;font-size:14px\"><br></p>\n" +
            "                       <table border=\"1\" align=\"center\" cellspacing=\"1\" cellpadding=\"1\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;border-style:none;margin:1rem 0;font-size:0.9rem;font-family:sans-serif;box-shadow:0 0 20px #D8D8D8;width:500px\" class=\"es-table styled-table\" role=\"presentation\">\n" +
            "                        <thead>\n" +
            "                         <tr style=\"background-color:#1672E6;color:#FFFFFF;text-align:center\">\n" +
            "                          <th scope=\"col\" style=\"border-style:none;padding:0.6rem 1rem 0.6rem 1rem;font-size:0.8rem\">Expected Delivery</th>\n" +
            "                          <th scope=\"col\" style=\"border-style:none;padding:0.6rem 1rem 0.6rem 1rem;font-size:0.8rem\">Password</th>\n" +
            "                         </tr>\n" +
            "                        </thead>\n" +
            "                         <tr style=\"border-bottom:1px solid #DDDDDD\">\n" +
            "                          <td style=\"padding:0.6rem 1rem 0.6rem 1rem;Margin:0;border-style:none;font-size:0.8rem;text-align:center\">[DELIVERY_DATE]</td>\n" +
            "                          <td style=\"padding:0.6rem 1rem 0.6rem 1rem;Margin:0;border-style:none;font-size:0.8rem;text-align:center\">[PASSWORD]</td>\n" +
            "                         </tr>\n" +
            "                       </table></td>\n" +
            "                     </tr>\n" +
            "                   </table></td>\n" +
            "                 </tr>\n" +
            "               </table></td>\n" +
            "             </tr>\n" +
            "             <tr>\n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\">\n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                 <tr>\n" +
            "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0\"><!--[if mso]><a href=\"[DOWNLOAD_LINK]\" target=\"_blank\" hidden>\n" +
            "\t<v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" esdevVmlButton href=\"[DOWNLOAD_LINK]\" \n" +
            "                style=\"height:41px; v-text-anchor:middle; width:183px\" arcsize=\"10%\" stroke=\"f\"  fillcolor=\"#3670de\">\n" +
            "\t\t<w:anchorlock></w:anchorlock>\n" +
            "\t\t<center style='color:#ffffff; font-family:roboto, \"helvetica neue\", helvetica, arial, sans-serif; font-size:15px; font-weight:400; line-height:15px;  mso-text-raise:1px'>View Status</center>\n" +
            "\t</v:roundrect></a>\n" +
            "<![endif]--><!--[if !mso]><!-- --><span class=\"msohide es-button-border-2 es-button-border\" style=\"border-style:solid;border-color:#2cb543;background:#3670de;border-width:0px;display:inline-block;border-radius:4px;width:auto;mso-hide:all\"><a href=\"[DOWNLOAD_LINK]\" class=\"es-button es-button-1\" target=\"_blank\" style=\"mso-style-priority:100 !important;text-decoration:none;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;color:#FFFFFF;font-size:18px;border-style:solid;border-color:#3670de;border-width:10px 30px;display:inline-block;background:#3670de;border-radius:4px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;font-weight:normal;font-style:normal;line-height:22px;width:auto;text-align:center\">View Status</a></span><!--<![endif]--></td>\n" +
            "                     </tr>\n" +
            "                   </table></td>\n" +
            "                 </tr>\n" +
            "               </table></td>\n" +
            "             </tr>\n" +
            "           </table></td>\n" +
            "         </tr>\n" +
            "       </table>\n" +
            "       <table class=\"es-footer\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" +
            "         <tr>\n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
            "           <table class=\"es-footer-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
            "             <tr>\n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\">\n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                 <tr>\n" +
            "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:40px;font-size:0\">\n" +
            "                       <table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                         <tr>\n" +
            "                          <td style=\"padding:0;Margin:0;border-bottom:1px solid #cccccc;background:unset;height:1px;width:100%;margin:0px\"></td>\n" +
            "                         </tr>\n" +
            "                       </table></td>\n" +
            "                     </tr>\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:30px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:14px;color:#d3d3d3;font-size:9px\">contact@work.download<br>Hannes Thöne<br>Nordstraße 16, 34414 Warburg,<br>Germany, Nordrhein-Westfalen<br><a target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#3670de;font-size:9px;white-space:nowrap;word-break:break-all\" href=\"[UNSUBSCRIBE_LINK]\">unsubscribe</a></p></td>\n" +
            "                     </tr>\n" +
            "                   </table></td>\n" +
            "                 </tr>\n" +
            "               </table></td>\n" +
            "             </tr>\n" +
            "           </table></td>\n" +
            "         </tr>\n" +
            "       </table></td>\n" +
            "     </tr>\n" +
            "   </table>\n" +
            "  </div>\n" +
            " </body>\n" +
            "</html>";

    private static final String passwordResetEmail = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
            "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" style=\"font-family:arial, 'helvetica neue', helvetica, sans-serif\">\n" +
            " <head>\n" +
            "  <meta charset=\"UTF-8\">\n" +
            "  <meta content=\"width=device-width, initial-scale=1\" name=\"viewport\">\n" +
            "  <meta name=\"x-apple-disable-message-reformatting\">\n" +
            "  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "  <meta content=\"telephone=no\" name=\"format-detection\">\n" +
            "  <title>PasswordReset</title><!--[if (mso 16)]>\n" +
            "    <style type=\"text/css\">\n" +
            "    a {text-decoration: none;}\n" +
            "    </style>\n" +
            "    <![endif]--><!--[if gte mso 9]><style>sup { font-size: 100% !important; }</style><![endif]--><!--[if gte mso 9]>\n" +
            "<xml>\n" +
            "    <o:OfficeDocumentSettings>\n" +
            "    <o:AllowPNG></o:AllowPNG>\n" +
            "    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
            "    </o:OfficeDocumentSettings>\n" +
            "</xml>\n" +
            "<![endif]--><!--[if !mso]><!-- -->\n" +
            "  <link href=\"https://fonts.googleapis.com/css?family=Roboto:400,400i,700,700i\" rel=\"stylesheet\"><!--<![endif]-->\n" +
            "  <style type=\"text/css\">\n" +
            "#outlook a {\n" +
            "\tpadding:0;\n" +
            "}\n" +
            ".es-button {\n" +
            "\tmso-style-priority:100!important;\n" +
            "\ttext-decoration:none!important;\n" +
            "}\n" +
            "a[x-apple-data-detectors] {\n" +
            "\tcolor:inherit!important;\n" +
            "\ttext-decoration:none!important;\n" +
            "\tfont-size:inherit!important;\n" +
            "\tfont-family:inherit!important;\n" +
            "\tfont-weight:inherit!important;\n" +
            "\tline-height:inherit!important;\n" +
            "}\n" +
            ".es-desk-hidden {\n" +
            "\tdisplay:none;\n" +
            "\tfloat:left;\n" +
            "\toverflow:hidden;\n" +
            "\twidth:0;\n" +
            "\tmax-height:0;\n" +
            "\tline-height:0;\n" +
            "\tmso-hide:all;\n" +
            "}\n" +
            "[data-ogsb] .es-button {\n" +
            "\tborder-width:0!important;\n" +
            "\tpadding:10px 20px 10px 20px!important;\n" +
            "}\n" +
            ".es-button-border:hover a.es-button, .es-button-border:hover button.es-button {\n" +
            "\tbackground:#56d66b!important;\n" +
            "\tborder-color:#56d66b!important;\n" +
            "}\n" +
            ".es-button-border:hover {\n" +
            "\tborder-color:#42d159 #42d159 #42d159 #42d159!important;\n" +
            "\tbackground:#56d66b!important;\n" +
            "}\n" +
            "td .es-button-border:hover a.es-button-1 {\n" +
            "\tbackground:#3670de!important;\n" +
            "\tborder-color:#3670de!important;\n" +
            "}\n" +
            "td .es-button-border-2:hover {\n" +
            "\tbackground:#3670de!important;\n" +
            "\tborder-style:solid solid solid solid!important;\n" +
            "\tborder-color:#42d159 #42d159 #42d159 #42d159!important;\n" +
            "}\n" +
            "[data-ogsb] .es-button.es-button-3 {\n" +
            "\tpadding:10px 30px!important;\n" +
            "}\n" +
            "@media only screen and (max-width:600px) {p, ul li, ol li, a { line-height:150%!important } h1, h2, h3, h1 a, h2 a, h3 a { line-height:120% } h1 { font-size:30px!important; text-align:left } h2 { font-size:24px!important; text-align:left } h3 { font-size:20px!important; text-align:left } .es-header-body h1 a, .es-content-body h1 a, .es-footer-body h1 a { font-size:30px!important; text-align:left } .es-header-body h2 a, .es-content-body h2 a, .es-footer-body h2 a { font-size:24px!important; text-align:left } .es-header-body h3 a, .es-content-body h3 a, .es-footer-body h3 a { font-size:20px!important; text-align:left } .es-menu td a { font-size:14px!important } .es-header-body p, .es-header-body ul li, .es-header-body ol li, .es-header-body a { font-size:14px!important } .es-content-body p, .es-content-body ul li, .es-content-body ol li, .es-content-body a { font-size:14px!important } .es-footer-body p, .es-footer-body ul li, .es-footer-body ol li, .es-footer-body a { font-size:9px!important } .es-infoblock p, .es-infoblock ul li, .es-infoblock ol li, .es-infoblock a { font-size:10px!important } *[class=\"gmail-fix\"] { display:none!important } .es-m-txt-c, .es-m-txt-c h1, .es-m-txt-c h2, .es-m-txt-c h3 { text-align:center!important } .es-m-txt-r, .es-m-txt-r h1, .es-m-txt-r h2, .es-m-txt-r h3 { text-align:right!important } .es-m-txt-l, .es-m-txt-l h1, .es-m-txt-l h2, .es-m-txt-l h3 { text-align:left!important } .es-m-txt-r img, .es-m-txt-c img, .es-m-txt-l img { display:inline!important } .es-button-border { display:inline-block!important } a.es-button, button.es-button { font-size:18px!important; display:inline-block!important } .es-adaptive table, .es-left, .es-right { width:100%!important } .es-content table, .es-header table, .es-footer table, .es-content, .es-footer, .es-header { width:100%!important; max-width:600px!important } .es-adapt-td { display:block!important; width:100%!important } .adapt-img { width:100%!important; height:auto!important } .es-m-p0 { padding:0px!important } .es-m-p0r { padding-right:0px!important } .es-m-p0l { padding-left:0px!important } .es-m-p0t { padding-top:0px!important } .es-m-p0b { padding-bottom:0!important } .es-m-p20b { padding-bottom:20px!important } .es-mobile-hidden, .es-hidden { display:none!important } tr.es-desk-hidden, td.es-desk-hidden, table.es-desk-hidden { width:auto!important; overflow:visible!important; float:none!important; max-height:inherit!important; line-height:inherit!important } tr.es-desk-hidden { display:table-row!important } table.es-desk-hidden { display:table!important } td.es-desk-menu-hidden { display:table-cell!important } .es-menu td { width:1%!important } table.es-table-not-adapt, .esd-block-html table { width:auto!important } table.es-social { display:inline-block!important } table.es-social td { display:inline-block!important } .es-desk-hidden { display:table-row!important; width:auto!important; overflow:visible!important; max-height:inherit!important } }\n" +
            "</style>\n" +
            " </head>\n" +
            " <body style=\"width:100%;font-family:arial, 'helvetica neue', helvetica, sans-serif;-webkit-text-size-adjust:100%;-ms-text-size-adjust:100%;padding:0;Margin:0\">\n" +
            "  <div class=\"es-wrapper-color\" style=\"background-color:#F6F6F6\"><!--[if gte mso 9]>\n" +
            "\t\t\t<v:background xmlns:v=\"urn:schemas-microsoft-com:vml\" fill=\"t\">\n" +
            "\t\t\t\t<v:fill type=\"tile\" color=\"#f6f6f6\"></v:fill>\n" +
            "\t\t\t</v:background>\n" +
            "\t\t<![endif]-->\n" +
            "   <table class=\"es-wrapper\" width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;padding:0;Margin:0;width:100%;height:100%;background-repeat:repeat;background-position:center top;background-color:#F6F6F6\">\n" +
            "     <tr>\n" +
            "      <td valign=\"top\" style=\"padding:0;Margin:0\">\n" +
            "       <table class=\"es-header\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" +
            "         <tr>\n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
            "           <table class=\"es-header-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
            "             <tr>\n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0\">\n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                 <tr>\n" +
            "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:600px\">\n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0;font-size:0px\"><img class=\"adapt-img\" src=\"https://yzpmim.stripocdn.email/content/guids/CABINET_5fbfa5789e54cd8d17f05d334a627bdfd50527901ea1afb188747e666aae6985/images/emailheaderwd.jpg\" alt style=\"display:block;border:0;outline:none;text-decoration:none;-ms-interpolation-mode:bicubic\" width=\"600\"></td>\n" +
            "                     </tr>\n" +
            "                   </table></td>\n" +
            "                 </tr>\n" +
            "               </table></td>\n" +
            "             </tr>\n" +
            "           </table></td>\n" +
            "         </tr>\n" +
            "       </table>\n" +
            "       <table class=\"es-content\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
            "         <tr>\n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
            "           <table class=\"es-content-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
            "             <tr>\n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;padding-left:20px;padding-right:20px;padding-top:40px\">\n" +
            "               <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                 <tr>\n" +
            "                  <td valign=\"top\" align=\"center\" style=\"padding:0;Margin:0;width:560px\">\n" +
            "                   <table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:21px;color:#333333;font-size:14px\"><strong>Hello&nbsp;\uD83D\uDC4B</strong></p><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:21px;color:#333333;font-size:14px\">This is the confirmation email for your password reset request</p></td>\n" +
            "                     </tr>\n" +
            "                   </table></td>\n" +
            "                 </tr>\n" +
            "               </table></td>\n" +
            "             </tr>\n" +
            "             <tr>\n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\">\n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                 <tr>\n" +
            "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0\"><!--[if mso]><a href=\"[RESET_LINK]\" target=\"_blank\" hidden>\n" +
            "\t<v:roundrect xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"urn:schemas-microsoft-com:office:word\" esdevVmlButton href=\"[RESET_LINK]\" \n" +
            "                style=\"height:41px; v-text-anchor:middle; width:190px\" arcsize=\"10%\" stroke=\"f\"  fillcolor=\"#3670de\">\n" +
            "\t\t<w:anchorlock></w:anchorlock>\n" +
            "\t\t<center style='color:#ffffff; font-family:roboto, \"helvetica neue\", helvetica, arial, sans-serif; font-size:15px; font-weight:400; line-height:15px;  mso-text-raise:1px'>Reset Password</center>\n" +
            "\t</v:roundrect></a>\n" +
            "<![endif]--><!--[if !mso]><!-- --><span class=\"msohide es-button-border-2 es-button-border\" style=\"border-style:solid;border-color:#2cb543;background:#3670de;border-width:0px;display:inline-block;border-radius:4px;width:auto;mso-hide:all\"><a href=\"[RESET_LINK]\" class=\"es-button es-button-1\" target=\"_blank\" style=\"mso-style-priority:100 !important;text-decoration:none;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;color:#FFFFFF;font-size:18px;border-style:solid;border-color:#3670de;border-width:10px 30px;display:inline-block;background:#3670de;border-radius:4px;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;font-weight:normal;font-style:normal;line-height:22px;width:auto;text-align:center\">Reset Password</a></span><!--<![endif]--></td>\n" +
            "                     </tr>\n" +
            "                   </table></td>\n" +
            "                 </tr>\n" +
            "               </table></td>\n" +
            "             </tr>\n" +
            "           </table></td>\n" +
            "         </tr>\n" +
            "       </table>\n" +
            "       <table cellpadding=\"0\" cellspacing=\"0\" class=\"es-content\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%\">\n" +
            "         <tr>\n" +
            "          <td class=\"es-info-area\" align=\"center\" style=\"padding:0;Margin:0\">\n" +
            "           <table bgcolor=\"#ffffff\" class=\"es-content-body\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
            "             <tr>\n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\">\n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                 <tr>\n" +
            "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" class=\"es-infoblock\" style=\"padding:0;Margin:0;line-height:14px;font-size:12px;color:#CCCCCC\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:13px;color:#a9a9a9;font-size:11px\">If you did not sign up on <a target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#3670de;font-size:11px\" href=\"https://work.download/\">work.download</a>, you can ignore this email</p></td>\n" +
            "                     </tr>\n" +
            "                   </table></td>\n" +
            "                 </tr>\n" +
            "               </table></td>\n" +
            "             </tr>\n" +
            "           </table></td>\n" +
            "         </tr>\n" +
            "       </table>\n" +
            "       <table class=\"es-footer\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;table-layout:fixed !important;width:100%;background-color:transparent;background-repeat:repeat;background-position:center top\">\n" +
            "         <tr>\n" +
            "          <td align=\"center\" style=\"padding:0;Margin:0\">\n" +
            "           <table class=\"es-footer-body\" cellspacing=\"0\" cellpadding=\"0\" bgcolor=\"#ffffff\" align=\"center\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px;background-color:#FFFFFF;width:600px\">\n" +
            "             <tr>\n" +
            "              <td align=\"left\" style=\"padding:0;Margin:0;padding-top:20px;padding-left:20px;padding-right:20px\">\n" +
            "               <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                 <tr>\n" +
            "                  <td align=\"center\" valign=\"top\" style=\"padding:0;Margin:0;width:560px\">\n" +
            "                   <table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" style=\"Margin:0;padding-left:20px;padding-right:20px;padding-top:30px;padding-bottom:40px;font-size:0\">\n" +
            "                       <table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\" style=\"mso-table-lspace:0pt;mso-table-rspace:0pt;border-collapse:collapse;border-spacing:0px\">\n" +
            "                         <tr>\n" +
            "                          <td style=\"padding:0;Margin:0;border-bottom:1px solid #cccccc;background:unset;height:1px;width:100%;margin:0px\"></td>\n" +
            "                         </tr>\n" +
            "                       </table></td>\n" +
            "                     </tr>\n" +
            "                     <tr>\n" +
            "                      <td align=\"center\" style=\"padding:0;Margin:0;padding-bottom:30px\"><p style=\"Margin:0;-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;font-family:roboto, 'helvetica neue', helvetica, arial, sans-serif;line-height:14px;color:#d3d3d3;font-size:9px\">contact@work.download<br>Hannes Thöne<br>Nordstraße 16, 34414 Warburg,<br>Germany, Nordrhein-Westfalen<br><a target=\"_blank\" style=\"-webkit-text-size-adjust:none;-ms-text-size-adjust:none;mso-line-height-rule:exactly;text-decoration:underline;color:#3670de;font-size:9px;white-space:nowrap;word-break:break-all\" href=\"[UNSUBSCRIBE_LINK]\">unsubscribe</a></p></td>\n" +
            "                     </tr>\n" +
            "                   </table></td>\n" +
            "                 </tr>\n" +
            "               </table></td>\n" +
            "             </tr>\n" +
            "           </table></td>\n" +
            "         </tr>\n" +
            "       </table></td>\n" +
            "     </tr>\n" +
            "   </table>\n" +
            "  </div>\n" +
            " </body>\n" +
            "</html>";

    public String createConfirmEmail(String name, String confirmLink, String unsubscribeLink) {


        String result = confirmEmail;

        result = result
                .replace("[NAME]", name)
                .replace("[CONFIRM_LINK]", confirmLink)
                .replace("[UNSUBSCRIBE_LINK]", unsubscribeLink);

        return result;

    }

    public String createDeliveredEmail(String deliverer, String deliveredOn, String password, String downloadLink, String unsubscribeLink) {


        String result = deliveredEmail;

        result = result
                .replace("[DELIVERER]", deliverer)
                .replace("[DELIVERED_ON]", deliveredOn)
                .replace("[PASSWORD]", password)
                .replace("[DOWNLOAD_LINK]", downloadLink)
                .replace("[UNSUBSCRIBE_LINK]", unsubscribeLink);

        return result;

    }

    public String createPasswordResetEmail(String link) {


        String result = passwordResetEmail;

        result = result
                .replace("[UNSUBSCRIBE_LINK]", "https://work.download/")
                .replace("[RESET_LINK]", link);

        return result;

    }

    public String createDeliveryCreatedEmail(String deliverer, String expectedDeliveryDate, String password, String downloadLink, String unsubscribeLink) {


        String result = deliveryCreatedEmail;

        result = result
                .replace("[DELIVERER]", deliverer)
                .replace("[DELIVERY_DATE]", expectedDeliveryDate)
                .replace("[PASSWORD]", password)
                .replace("[DOWNLOAD_LINK]", downloadLink)
                .replace("[UNSUBSCRIBE_LINK]", unsubscribeLink);

        return result;

    }


}
