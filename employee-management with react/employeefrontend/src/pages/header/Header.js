import Navbar from "react-bootstrap/Navbar"
import Container from "react-bootstrap/Container"
import Nav from "react-bootstrap/Nav"
import { Link as link } from "react-router-dom"

const Header = () => {
    return (
        <>
        <Navbar bg ="primary" variant="dark">
            <Container>
                <Navbar.Brand href="/"><strong>Employee Management System</strong></Navbar.Brand>
                <Nav className="ml-auto">
                    <Nav.Link as={link} to ="/" className="nav-link">Employee</Nav.Link>
                    <Nav.Link as={link} to ="/employee" className="nav-link">Post Employee</Nav.Link>
                </Nav>
            </Container>
        </Navbar>
        </>
    )
}
export default Header