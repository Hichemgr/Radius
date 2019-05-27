<?php

namespace SlimBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Utilisateur
 *
 * @ORM\Table(name="utilisateur")
 * @ORM\Entity
 */
class Utilisateur
{
    /**
     * @var integer
     *
     * @ORM\Column(name="idutilisateur", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idutilisateur;

    /**
     * @var integer
     *
     * @ORM\Column(name="cin", type="integer", nullable=false)
     */
    private $cin;

    /**
     * @var string
     *
     * @ORM\Column(name="nom", type="string", length=50, nullable=false)
     */
    private $nom;

    /**
     * @var string
     *
     * @ORM\Column(name="prenom", type="string", length=50, nullable=false)
     */
    private $prenom;

    /**
     * @var string
     *
     * @ORM\Column(name="motdepasse", type="string", length=150, nullable=false)
     */
    private $motdepasse;

    /**
     * @var string
     *
     * @ORM\Column(name="adressemail", type="string", length=50, nullable=false)
     */
    private $adressemail;

    /**
     * @var integer
     *
     * @ORM\Column(name="telephone", type="integer", nullable=false)
     */
    private $telephone;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="datecreation", type="date", nullable=false)
     */
    private $datecreation;

    /**
     * @var string
     *
     * @ORM\Column(name="status", type="string", length=50, nullable=false)
     */
    private $status;

    /**
     * @var string
     *
     * @ORM\Column(name="role", type="string", length=50, nullable=false)
     */
    private $role;

    /**
     * @var string
     *
     * @ORM\Column(name="photoprofil", type="string", length=50, nullable=false)
     */
    private $photoprofil;

    /**
     * @var integer
     *
     * @ORM\Column(name="nbpoint", type="integer", nullable=false)
     */
    private $nbpoint;

    /**
     * @var string
     *
     * @ORM\Column(name="adresse", type="string", length=100, nullable=false)
     */
    private $adresse;

    /**
     * @var string
     *
     * @ORM\Column(name="codevalidation", type="string", length=100, nullable=true)
     */
    private $codevalidation;

    /**
     * @return int
     */
    public function getIdutilisateur()
    {
        return $this->idutilisateur;
    }

    /**
     * @param int $idutilisateur
     */
    public function setIdutilisateur($idutilisateur)
    {
        $this->idutilisateur = $idutilisateur;
    }

    /**
     * @return int
     */
    public function getCin()
    {
        return $this->cin;
    }

    /**
     * @param int $cin
     */
    public function setCin($cin)
    {
        $this->cin = $cin;
    }

    /**
     * @return string
     */
    public function getNom()
    {
        return $this->nom;
    }

    /**
     * @param string $nom
     */
    public function setNom($nom)
    {
        $this->nom = $nom;
    }

    /**
     * @return string
     */
    public function getPrenom()
    {
        return $this->prenom;
    }

    /**
     * @param string $prenom
     */
    public function setPrenom($prenom)
    {
        $this->prenom = $prenom;
    }

    /**
     * @return string
     */
    public function getMotdepasse()
    {
        return $this->motdepasse;
    }

    /**
     * @param string $motdepasse
     */
    public function setMotdepasse($motdepasse)
    {
        $this->motdepasse = $motdepasse;
    }

    /**
     * @return string
     */
    public function getAdressemail()
    {
        return $this->adressemail;
    }

    /**
     * @param string $adressemail
     */
    public function setAdressemail($adressemail)
    {
        $this->adressemail = $adressemail;
    }

    /**
     * @return int
     */
    public function getTelephone()
    {
        return $this->telephone;
    }

    /**
     * @param int $telephone
     */
    public function setTelephone($telephone)
    {
        $this->telephone = $telephone;
    }

    /**
     * @return \DateTime
     */
    public function getDatecreation()
    {
        return $this->datecreation;
    }

    /**
     * @param \DateTime $datecreation
     */
    public function setDatecreation($datecreation)
    {
        $this->datecreation = $datecreation;
    }

    /**
     * @return string
     */
    public function getStatus()
    {
        return $this->status;
    }

    /**
     * @param string $status
     */
    public function setStatus($status)
    {
        $this->status = $status;
    }

    /**
     * @return string
     */
    public function getRole()
    {
        return $this->role;
    }

    /**
     * @param string $role
     */
    public function setRole($role)
    {
        $this->role = $role;
    }

    /**
     * @return string
     */
    public function getPhotoprofil()
    {
        return $this->photoprofil;
    }

    /**
     * @param string $photoprofil
     */
    public function setPhotoprofil($photoprofil)
    {
        $this->photoprofil = $photoprofil;
    }

    /**
     * @return int
     */
    public function getNbpoint()
    {
        return $this->nbpoint;
    }

    /**
     * @param int $nbpoint
     */
    public function setNbpoint($nbpoint)
    {
        $this->nbpoint = $nbpoint;
    }

    /**
     * @return string
     */
    public function getAdresse()
    {
        return $this->adresse;
    }

    /**
     * @param string $adresse
     */
    public function setAdresse($adresse)
    {
        $this->adresse = $adresse;
    }

    /**
     * @return string
     */
    public function getCodevalidation()
    {
        return $this->codevalidation;
    }

    /**
     * @param string $codevalidation
     */
    public function setCodevalidation($codevalidation)
    {
        $this->codevalidation = $codevalidation;
    }


}

