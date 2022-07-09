<%@ page import="Nouns.Reimbursement" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Request List - Manager View</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>

<body class="container">

<div class="display-1">Reimbursement Requests</div>
<hr/>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Id</th>
            <th>Username</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Amount</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
           <%
               List<Reimbursement> rqts= (List<Reimbursement>) request.getAttribute("all-requests");
               for(Reimbursement renminbi:rqts){
           %>
            <tr>
                <td><%=renminbi.getReqID()%></td>
                <td><%=renminbi.getUsername()%></td>
                <td><%=renminbi.getFName()%></td>
                <td><%=renminbi.getLName()%></td>
                <td><%=renminbi.getReqAmt()%></td>
                <td><a href="approve-request?id=<%=renminbi.getReqID()%>"><i style="cursor: pointer" class="fa-solid fa-check"></i></a></td>
                <td><a href="deny-request?id=<%=renminbi.getReqID()%>"><i style="cursor: pointer" class="fa-solid fa-xmark"></i></a></td>
                
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

</body>
</html>
