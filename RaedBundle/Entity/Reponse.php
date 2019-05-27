<?php

namespace SlimBundle\Entity;

/**
 * Reponse
 */
class Reponse
{
    /**
     * @var string
     */
    private $contenu;

    /**
     * @var integer
     */
    private $visible;

    /**
     * @var string
     */
    private $nom;

    /**
     * @var integer
     */
    private $idreponse;

    /**
     * @var \AppBundle\Entity\Utilisateur
     */
    private $idutilisateur;

    /**
     * @var \AppBundle\Entity\Question
     */
    private $idquestion;


    /**
     * Set contenu
     *
     * @param string $contenu
     *
     * @return Reponse
     */
    public function setContenu($contenu)
    {
        $this->contenu = $contenu;

        return $this;
    }

    /**
     * Get contenu
     *
     * @return string
     */
    public function getContenu()
    {
        return $this->contenu;
    }

    /**
     * Set visible
     *
     * @param integer $visible
     *
     * @return Reponse
     */
    public function setVisible($visible)
    {
        $this->visible = $visible;

        return $this;
    }

    /**
     * Get visible
     *
     * @return integer
     */
    public function getVisible()
    {
        return $this->visible;
    }

    /**
     * Set nom
     *
     * @param string $nom
     *
     * @return Reponse
     */
    public function setNom($nom)
    {
        $this->nom = $nom;

        return $this;
    }

    /**
     * Get nom
     *
     * @return string
     */
    public function getNom()
    {
        return $this->nom;
    }

    /**
     * Get idreponse
     *
     * @return integer
     */
    public function getIdreponse()
    {
        return $this->idreponse;
    }

    /**
     * Set idutilisateur
     *
     * @param \AppBundle\Entity\Utilisateur $idutilisateur
     *
     * @return Reponse
     */
    public function setIdutilisateur(\AppBundle\Entity\Utilisateur $idutilisateur = null)
    {
        $this->idutilisateur = $idutilisateur;

        return $this;
    }

    /**
     * Get idutilisateur
     *
     * @return \AppBundle\Entity\Utilisateur
     */
    public function getIdutilisateur()
    {
        return $this->idutilisateur;
    }

    /**
     * Set idquestion
     *
     * @param \AppBundle\Entity\Question $idquestion
     *
     * @return Reponse
     */
    public function setIdquestion(\AppBundle\Entity\Question $idquestion = null)
    {
        $this->idquestion = $idquestion;

        return $this;
    }

    /**
     * Get idquestion
     *
     * @return \AppBundle\Entity\Question
     */
    public function getIdquestion()
    {
        return $this->idquestion;
    }
}

