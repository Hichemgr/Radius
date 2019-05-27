<?php

namespace SlimBundle\Entity;

/**
 * Question
 */
class Question
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
     * @var string
     */
    private $contenuReponse;

    /**
     * @var integer
     */
    private $idquestion;

    /**
     * @var \AppBundle\Entity\Utilisateur
     */
    private $idutilisateur;


    /**
     * Set contenu
     *
     * @param string $contenu
     *
     * @return Question
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
     * @return Question
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
     * @return Question
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
     * Set contenuReponse
     *
     * @param string $contenuReponse
     *
     * @return Question
     */
    public function setContenuReponse($contenuReponse)
    {
        $this->contenuReponse = $contenuReponse;

        return $this;
    }

    /**
     * Get contenuReponse
     *
     * @return string
     */
    public function getContenuReponse()
    {
        return $this->contenuReponse;
    }

    /**
     * Get idquestion
     *
     * @return integer
     */
    public function getIdquestion()
    {
        return $this->idquestion;
    }

    /**
     * Set idutilisateur
     *
     * @param \AppBundle\Entity\Utilisateur $idutilisateur
     *
     * @return Question
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
}

